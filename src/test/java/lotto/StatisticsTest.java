package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatisticsTest {

	private Lottos lottos;
	private Statistics statistics;

	@BeforeEach
	void before() {
		List<Lotto> lottoList = new ArrayList<>();
		lottoList.add(new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16)));
		lottoList.add(new Lotto(Arrays.asList(21, 22, 23, 24, 15, 16)));
		lottoList.add(new Lotto(Arrays.asList(31, 32, 33, 14, 35, 16)));
		lottoList.add(new Lotto(Arrays.asList(31, 32, 33, 14, 35, 16)));
		lottoList.add(new Lotto(Arrays.asList(31, 32, 33, 14, 35, 16)));
		lottoList.add(new Lotto(Arrays.asList(31, 32, 33, 14, 35, 16)));
		lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 14, 15, 16)));

		lottos = new Lottos(lottoList);
		statistics = new Statistics(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

	}

	@Test
	@DisplayName("생성 테스트")
	void create() {
		assertThat(statistics).isNotNull();
		for (Prize prize : Prize.values()) {
			assertThat(statistics.status(prize)).isEqualTo(0);
		}
	}

	@Test
	@DisplayName("당첨 현황 테스트")
	void statistics() {
		statistics.analyze(lottos);
		assertThat(statistics.status(Prize.SIX)).isEqualTo(0);
		assertThat(statistics.status(Prize.FIVE)).isEqualTo(0);
		assertThat(statistics.status(Prize.FOUR)).isEqualTo(0);
		assertThat(statistics.status(Prize.THREE)).isEqualTo(1);
	}

	@Test
	@DisplayName("수익률 계산")
	void profitRate() {
		statistics.analyze(lottos);
		Profit profit = statistics.profit();
		assertThat(profit.rate()).isEqualTo(0.71);
	}
}

