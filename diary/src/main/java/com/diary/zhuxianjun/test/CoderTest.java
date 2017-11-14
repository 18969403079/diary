package com.diary.zhuxianjun.test;

public class CoderTest {

	private String name;

	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CoderTest) {
			CoderTest coder = (CoderTest)obj;
			return coder.getName().equals(this.name) && coder.getAge() == this.age;
		} else {
			return false;
		}
	}
	
	

	@Override
	public int hashCode() {
		
		return super.hashCode();
	}

	public static void main(String[] args) {
		int a = 3;
		int b = 3;
		Integer c = 3;
		Integer d = 3;
		System.out.println(a == b);
		System.out.println(c == d);
		System.out.println(c.equals(d));
		
		char aa = 'd';
		char bb = 'd';
		System.out.println(aa == bb);
		
		CoderTest a1 = new CoderTest();
		a1.setAge(1);
		a1.setName("1");
		CoderTest a2 = new CoderTest();
		a2.setAge(1);
		a2.setName("1");
		System.out.println(a1.equals(a2));
	}

}
