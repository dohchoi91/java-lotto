package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Set Collection에 대한 학습 테스트")
public class SetTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@Test
	@DisplayName("요구사항 1 : size() 메소드를 활용해 Set의 크기를 확인")
	void size() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@ParameterizedTest(name = "Find : {argumentsWithNames}")
	@ValueSource(ints = {1, 2, 3} )
	@DisplayName("요구사항 2 : contains() 메소드를 활용한 값이 존재 유무 확인 ")
	void contains(int number) {
		assertThat(numbers.contains(number)).isTrue();
	}

	@ParameterizedTest(name = "Case : {argumentsWithNames}")
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	@DisplayName("요구사항 3 : contains() 메소드를 활용한 값이 포함 결과값 확인")
	void containsWithResult(int input, boolean expected) {
		assertThat(numbers.contains(input)).isEqualTo(expected);
	}
}
