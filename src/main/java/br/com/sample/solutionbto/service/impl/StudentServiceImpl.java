package br.com.sample.solutionbto.service.impl;

import br.com.sample.solutionbto.model.Student;
import br.com.sample.solutionbto.model.StudentAggregate;
import br.com.sample.solutionbto.repository.StudentRepository;
import br.com.sample.solutionbto.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.DateOperators;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.*;

import static com.mongodb.client.model.Accumulators.sum;
import static com.mongodb.client.model.Aggregates.*;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;
	private MongoTemplate mongoTemplate;

	public StudentServiceImpl(StudentRepository studentRepository, MongoTemplate mongoTemplate) {
		this.studentRepository = studentRepository;
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(String id) {
		return studentRepository.findById(id).orElse(null);
	}

	@Override
	public Student insert(Student student) {
		student.setCreated(LocalDateTime.now());
		return studentRepository.save(student);
	}
	
	@Override
	public Student update(Student student) {
		student.setModified(LocalDateTime.now());
		return studentRepository.save(student);
	}

	/**
	 * Simple sample of aggregates, in development...
	 * @return
	 */
	@Override
	public StudentAggregate summary(){
		// see for more concepts: https://www.baeldung.com/java-mongodb-aggregations ,
		// https://www.mongodb.com/developer/quickstart/java-aggregation-pipeline/
		// https://www.mongodb.com/docs/manual/reference/operator/aggregation/dateToString/

		// init
		var summary = StudentAggregate.builder()
				.birthdaySummary(new ArrayList<>())
				.citiesSummary(new ArrayList<>())
				.build();

		// summary of cities
		var collection = mongoTemplate.getCollection("student");
		var groupCities = group("$city", sum("count",1l));
		var citiesSummary = collection.aggregate(Arrays.asList(groupCities)).into(new ArrayList<>());
		for(Document doc : citiesSummary){
			summary.getCitiesSummary()
					.add(new StudentAggregate.CitiesSummary(doc.get("_id", String.class), BigInteger.valueOf(doc.get("count", Long.class))));
		}

		// summary of birthday
		Aggregation aggregation = Aggregation.newAggregation(
			Aggregation.project("id")
					.and(DateOperators.dateOf("$birthDay").toString("%m%Y")).as("monthYearBirth"),
				Aggregation.group("monthYearBirth").count().as("total"),
				Aggregation.sort(Sort.Direction.ASC,"total")
		);
		AggregationResults<Document> studentAggregates = mongoTemplate.aggregate(aggregation,"student",Document.class);
		var birthdaySummary = studentAggregates.getMappedResults();
		for(Document doc : birthdaySummary){
			summary.getBirthdaySummary()
					.add(new StudentAggregate.BirthdaySummary(doc.get("_id", String.class), BigInteger.valueOf(doc.get("total",Integer.class))));
		}

		return summary;
	}

	@Override
	public void delete(String id) {
		this.studentRepository.deleteById(id);
	}
}
