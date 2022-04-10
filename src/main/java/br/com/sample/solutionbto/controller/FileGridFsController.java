package br.com.sample.solutionbto.controller;

import br.com.sample.solutionbto.model.FileGridFS;
import br.com.sample.solutionbto.service.FileGridFsService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/**
 * Represent upload , download , delete and retrive files
 * sample basead in course Udemy and https://www.baeldung.com/spring-boot-mongodb-upload-file
 */
@Api(tags = "file-gridfs")
@RestController
@RequestMapping("/api/v1")
public class FileGridFsController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private FileGridFsService fileGridFsService;

	@Autowired
	private GridFsTemplate gridFsTemplate;

	@Autowired
	private GridFsOperations operations;

	@GetMapping("/file-gridfs")
	public List<FileGridFS> list() throws IOException{
		return this.fileGridFsService.findAll();
	}

	@GetMapping("/file-gridfs/{id}")
	public HttpEntity getFindById(@PathVariable String id) throws IOException{

		FileGridFS fileGridFS = fileGridFsService.findById(id);

		if(fileGridFS != null) {

			GridFSFile gridFSFile = gridFsTemplate
					.findOne(Query.query(GridFsCriteria.whereMetaData("file_id").is(id)));
			GridFsResource gridFsResource = null;

			if (gridFSFile != null)
				gridFsResource = operations.getResource(gridFSFile);

			if (gridFsResource != null &&
					gridFsResource.exists()) {

				ByteArrayOutputStream os=new ByteArrayOutputStream();
				os.write(gridFsResource.getInputStream().readAllBytes());

				HttpHeaders httpHeaders = new HttpHeaders();
				httpHeaders.set(HttpHeaders.CONTENT_TYPE, fileGridFS.getContentType());
				return new HttpEntity<>(os.toByteArray(), httpHeaders);
			}
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/file-gridfs")
	public FileGridFS post(@RequestBody MultipartFile file) throws IOException {
			logger.info("fileName={} , content-type={}",file.getOriginalFilename() , file.getContentType());

			if(!StringUtils.isEmpty(file.getContentType())) {

				DBObject metadata = new BasicDBObject();
				FileGridFS fileGridFS = new FileGridFS(file.getOriginalFilename(), file.getContentType(),file.getSize());

				fileGridFsService.insert(fileGridFS);

				metadata.put("file_id", fileGridFS.getId());
				gridFsTemplate.store(
						file.getInputStream(),
						file.getOriginalFilename(),
						file.getContentType(),
						metadata);

				return fileGridFS;
			}
			else
				throw new RuntimeException("Content-Type is null!");
	}

	@DeleteMapping("/file-gridfs/{id}")
	public void delete(@PathVariable String id) {
		gridFsTemplate.delete(new Query(Criteria.where("file_id").is(id)));
		fileGridFsService.delete(id);
	}
}
