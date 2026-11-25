package eje1;

public record T(Integer a, Integer b) {
	public static T of(Integer i, int b) {
		return new T(i, b);
	}

	public static void main(String[] args) {
		System.out.println(T.of(2, 3));

	}
}
