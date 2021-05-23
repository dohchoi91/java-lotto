package lotto;

import java.util.Objects;

public class Money {
	public static final String UNIT_KR = "원";

	private final long money;

	public Money(long money) {
		this.money = money;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Money money1 = (Money)o;
		return money == money1.money;
	}

	@Override
	public int hashCode() {
		return Objects.hash(money);
	}


	public Money multiply(int value) {
		return new Money(money * value);
	}

	public Money plus(Money value) {
		return new Money(money + value.money);
	}

	public boolean isZero() {
		return money == 0;
	}

	public double divide(Money value) {
		return (double)money / value.money;
	}

	public String won() {
		return money + UNIT_KR;
	}
}
