# ๐ ๋น๋ ํจํด(Builder Pattern)

<br />

`์์ฑ ํจํด`์ค ํ๋์ธ `๋น๋ ํจํด`์ ๋๋ถ๋ถ์ ์๋ฐ ๊ฐ๋ฐ์ ๋ถ๋ค์ด `๋กฌ๋ณต(Lombok)`์ ํตํด ์์ฃผ ๋ง์ด ์ฌ์ฉํ๊ณ  ์๋ ํจํด์๋๋ค.

์ด๋ฏธ ๋กฌ๋ณต์ ํตํด ์์ฃผ ์ฝ๊ฒ ์ฌ์ฉํ๊ณ , ์ฌ๋ฌ๊ฐ์ง ์ต์๋ ์ค ์ ์๋ ํจํด์ด๋ผ ์ฌ์ค ์ง์  ๊ตฌํํ  ์ผ์ด ๋ง์ง๋ ์์ ๊ฒ ๊ฐ์ต๋๋ค.

[์ดํํฐ๋ธ ์๋ฐ](http://www.kyobobook.co.kr/product/detailViewKor.laf?mallGb=KOR&ejkGb=KOR&barcode=9788966262281) ์์๋ ์ด ๋น๋ ํจํด์ ๋ํด ์ ์ธต์  ์์ฑ์ ํจํด์ ์ฌ์ฉํ๋ ๊ฒ๋ณด๋ค ํจ์จ์ ์ผ ๊ฒ์ด๋ผ๊ณ  ์ค๋ชํฉ๋๋ค.

๋์ฒด๋ก ์์ฑ์ ๋งค๊ฐ๋ณ์๊ฐ 2~3๊ฐ ์ดํ๋ผ๋ฉด ์ ์  ํฉํ ๋ฆฌ ๋ฉ์๋๋ฅผ ํตํด ๊ฐ์ฒด ์์ฑ์ ๊ถ์ฅํ๋ฉฐ, ๊ทธ ์ด์์ผ ๊ฒฝ์ฐ ๋ง์ ๋งค๊ฐ๋ณ์๋ฅผ ๋ฌถ์ด์ฃผ๋ ๋์ฐ๋ฏธ ํด๋์ค๋ฅผ ์์ฑํ๊ฑฐ๋, ์ด ๋น๋ ํจํด์ ์ฌ์ฉ์ ๊ณ ๋ คํ๋ผ๊ณ  ํ๊ณ  ์์ต๋๋ค.

<br />

์  ๊ฒฝ์ฐ์ ์์ฑ์ ๋งค๊ฐ๋ณ์๊ฐ 3~4๊ฐ๊ฐ ๋์ด๊ฐ๋ค๋ฉด ๋์ฒด๋ก ๋น๋ ํจํด์ ์ฌ์ฉํ๋ ๊ฒ ๊ฐ์ต๋๋ค. ๊ทธ ์ดํ๋ผ๋ฉด ์ ์  ํฉํ ๋ฆฌ ๋ฉ์๋๋ฅผ ์ด์ฉํฉ๋๋ค.

<br >

๋น๋ ํจํด์ ์ฅ์ ์ผ๋ก๋ ๊ฐ์ฒด ์์ฑ ์ ๊น์ง ๊ฐ์ฒด์ ์ํ๊ฐ ์ผ๊ด์ฑ์ ๊ฐ๋๋ค๋ ๊ฒ์๋๋ค.

๋จ์ ์ผ๋ก๋ ํํ [๋ณด์ผ๋ฌ ํ๋ ์ดํธ ์ฝ๋](https://ko.wikipedia.org/wiki/%EC%83%81%EC%9A%A9%EA%B5%AC_%EC%BD%94%EB%93%9C) ๋ผ๊ณ  ๋ถ๋ฆฌ๋ ๊ฒ์ด ๋๋์ผ๋ก ์๊ธด๋ค๋ ์ ์๋๋ค.

ํ์ง๋ง ์๋ฐ์์๋ ์ด ๊ท์ฐฎ์ ์์์ ๋กฌ๋ณต์ด ๋์  ์ฒ๋ฆฌ ํด ์ค๋๋ค.

๋ง์ฝ ๋น๋ ํจํด์ ์ฌ์ฉํ  ๋๋ง๋ค ์ง์  ์ฝ๋๋ฅผ ์์ฑํด์ผ ํ๋ค๋ฉด, ์ ๋ง ๊ท์ฐฎ๊ณ  ์ง๋ฃจํ ์์์ด ๋์ง ์์๊น ์ถ๋ค์.

<br />

๋น๋ ํจํด์ด ํ์ฉ๋๊ธฐ ์ ๊น์ง ๊ฐ์ฒด ์์ฑ์ ๋ค์๊ณผ ๊ฐ์ ๋ฐฉ๋ฒ๋ค๋ก ์ด๋ฃจ์ด ์ก์ต๋๋ค.

<br />

```java
public Member createMember(){
        Member member=new Member();
        member.setName("shirohoo");
        member.setAge(1);
        member.set...;
        member.set...;
        member.set...;
        member.set...;
        return member;
        }
```

<br />

์ ๋ฐฉ๋ฒ์ ์์ง๋ ์์ฃผ ๋ง์ด ์ฌ์ฉ๋๊ณ  ์๋ ๋ฐฉ๋ฒ์ด์ง๋ง, ์น๋ช์ ์ธ ๋จ์ ์ด ๋๊ฐ์ง ์์ต๋๋ค.

์ฒซ์งธ๋ก, ๋ชจ๋  ์์ ์์ ํธ์ถ์ด ๋๋ ๋๊น์ง ๊ฐ์ฒด์ ์ํ๊ฐ ๋งค์ฐ ๋ถ์์ ํ๋ค๋ ๊ฒ์๋๋ค.

๋ง์ฝ ์์ ์๊ฐ ํธ์ถ๋๋ ์์ค ์์ธ๊ฐ ๋ฐ์ํ๋ค๋ฉด ๊ฐ์ฒด๊ฐ ์๋ฒฝํ ์ํ๋ก ์ด๊ธฐํ๋์ง ๋ชปํ์ฑ๋ก ์๋ฅด๋ฅด ๋ฌด๋์ง๊ฒ ๋ฉ๋๋ค.

๋์งธ๋ก, ๋ชจ๋  ํด๋์ค ๋ณ์์ ๋ํด ์์ ์(Setter)๋ฅผ ์์ฑํด์ผ ํฉ๋๋ค.

์ด๋ด ๊ฒฝ์ฐ ๊ฐ์ฒด์ ์บก์ํ๊ฐ ๊นจ์ง๊ธฐ ๋๋ฌธ์ ๊ฐ์ฒด์งํฅ ํ๋ก๊ทธ๋๋ฐ์์ ๊ถ์ฅํ๋ ๋ฐฉ๋ฒ์ ์๋๋๋ค.

๋ค์์ ์์ฑ์๋ฅผ ์ฌ์ฉํ ๋ฐฉ๋ฒ์๋๋ค.

<br />

```java
public Member createMember(){
        return new Member("f","m","l",5,"ko");
        }
```

<br />

์ด ๋ฐฉ๋ฒ๋ ์ฌ์ ํ ๋จ์ ์ด ์์ต๋๋ค.

์ผ๋จ ๋งค๊ฐ๋ณ์๊ฐ ๋ง์์ง ๊ฒฝ์ฐ ๊ฐ๋ฐ์๊ฐ ๋ชจ๋  ๋งค๊ฐ๋ณ์์ ํ์๊ณผ ์์๋ฅผ ์ ํํ ์งํค๊ธฐ ํ๋ค์ด์ง๊ธฐ ๋๋ฌธ์ ๋ฌธ์ ๊ฐ ๋ฐ์ ํ  ๊ฐ๋ฅ์ฑ์ด ๋งค์ฐ ๋์์ง๋๋ค.

์ด ๊ฒฝ์ฐ ํนํ ๊ฐ์ ํ์์ ๋งค๊ฐ๋ณ์๊ฐ ์ฐ์์ ์ผ๋ก ์๋ ฅ๋์ผ ํ  ๊ฒฝ์ฐ ์์๊ฐ ๋๋์ฑ ์ค์ํด์ง๋๋ฐ, ๊ฐ๋ฐ์๊ฐ ํท๊ฐ๋ฆด ๊ฐ๋ฅ์ฑ์ด ๋์ฑ ๋์์ง๋๋ค.

<br />

๋ํ ํด๋น ์์ฑ์๊ฐ ์ด๋ค ์์ ์ ํธ์ถ๋์ด์ผ ํ  ์ง ๊ฐ๋ฐ์๊ฐ API๋ฌธ์๋ฅผ ๋ณด์ง ์๊ณ ๋ ์ ์ ์์ต๋๋ค.

์์ฑ์์ ๊ณ ์ง์ ์ธ ๋จ์ ์ธ๋ฐ, ์์ฑ์๋ `new` ํค์๋๋ฅผ ํตํด ์ฌ์ฉ๋๊ธฐ ๋๋ฌธ์ `์ด๋ฆ`์ ๊ฐ์ง ์ ์์ต๋๋ค.

<br />

์์ ๋จ์ ๋ค ์ค ์ผ๋ถ๋ IDE์ ๋์์ ๋ฐ๋๋ค๋ฉด ์ด๋์ ๋ ๊ทน๋ณตํ  ์ ์๊ธฐ๋ ํฉ๋๋ค.

ํ์ง๋ง IDE๋ฅผ ์ฌ์ฉํ์ง ์๋ ๊ฐ๋ฐ์๋ผ๋ฉด ๋ฐ๋ก API ๋ฌธ์๋ฅผ ์ฐพ์ผ๋ฌ ๋ฌ๋ ค๊ฐ์ผ ํ ์ง๋ ๋ชจ๋ฆ๋๋ค. ~~(IDE๋ฅผ ์ฐ์ง์๋ ๊ฐ๋ฐ์๊ฐ ์๊ธดํ ๊น์? ๐ค)~~

<br />

```java
public static Member whenRegistering(String firstName,String middleName,String lastName,int age,String country){
        return new Member(firstName,middleName,lastName,age,country);
        }
```       

<br />

```java
Member.whenRegistering("f","m","l",5,"ko");
```

<br />

์์ ๋ฐฉ๋ฒ์ ์ ์  ํฉํ ๋ฆฌ ๋ฉ์๋๋ฅผ ํ์ฉํ ๋ฐฉ๋ฒ์๋๋ค.

์์ฑ์์ ์ด๋ฆ์ ๊ฐ์ง ์ ์๋ค๋ ๋จ์ ์ ๋ชํํ๊ฒ ํด๊ฒฐ ํด ์ค๋๋ค.

ํ์ง๋ง ์ฌ์ ํ ์ธ์๊ฐ ๋ง์ ๊ฒฝ์ฐ ์์ฑ์์ ๊ฐ์ ๋จ์ ์ ๊ณต์ ํฉ๋๋ค.

<br />

```java
public static void main(String[]args){
        Member member=Member.builder()
        .firstName("f")
        .middleName("m")
        .lastName("l")
        .age(1)
        .country("ko")
        .build();
        }
```

<br />

๋น๋ ํจํด์ ์ฌ์ฉํ ๋ชจ์ต์๋๋ค.

๊ฐ์ฒด์ ์ํ๋ฅผ ํ๋์ ํ์ ํ  ์ ์์ต๋๋ค.

๋ํ `build()`๊ฐ ํธ์ถ๋๊ธฐ ์  ๊น์ง `Member`๋ ์์ฑ๋์ง ์์ ์ํ์ด๋ฉฐ, `build()`๊ฐ ํธ์ถ๋๋ ์๊ฐ `Member`์ ์ํ๊ฐ ๊ฒฐ์ ๋๋ฉฐ ์ธ์คํด์ค๊ฐ ์์ฑ๋๋ฏ๋ก, ์ํ์ผ๊ด์ฑ์ด ์ ์ง๋ฉ๋๋ค.

๋ค์์ ๋น๋ ํจํด์ ๊ตฌํํ ์ฝ๋์๋๋ค.

<br />

```java
public class Member {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final int age;
    private final String country;

    private Member(String firstName, String middleName, String lastName, int age, String country) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.country = country;
    }

    public static MemberBuilder builder() {
        return new MemberBuilder();
    }

    public static class MemberBuilder {
        private String firstName;
        private String middleName;
        private String lastName;
        private int age;
        private String country;

        private MemberBuilder() {}

        public MemberBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public MemberBuilder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public MemberBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public MemberBuilder age(int age) {
            this.age = age;
            return this;
        }

        public MemberBuilder country(String country) {
            this.country = country;
            return this;
        }

        public Member build() {
            return new Member(this.firstName, this.middleName, this.lastName, this.age, this.country);
        }
    }
}
```

<br />

๋ณด์๋ค์ํผ ๋น๋ ํ๋๋ง ๊ตฌํํ์์๋ ๋ถ๊ตฌํ๊ณ  ๊ต์ฅํ ๋ง์ ์ฝ๋๊ฐ ์์ฑ๋์ด์ผ ํฉ๋๋ค.

๋ํ ์ด ๋๋์ ์ฝ๋๋ค์ ๋๋ถ๋ถ์ ๊ฐ์ฒด์ ๋ฐ๊ณ ์ ์ ์ผ๋ก ๋ค์ด๊ฐ๋ ์ฝ๋๋ค์ด๊ธฐ๋ ํฉ๋๋ค.

์ฌ๊ธฐ์ `์ ๊ทผ์(Getter)`, `์์ ์(Setter)`, `์์ฑ์(Constructor)` ๋ฑ์ ์ถ๊ฐํ๋ค๋ฉด ๋ณด์ผ๋ฌ ํ๋ ์ดํธ๋ง 100์ค์ด ๋์ด๊ฐ๋ ๊ฒฝ์ฐ๋ ์ข์ข ์๊น๋๋ค.

์ด๋ฌํ ๋ฌธ์ ๋ฅผ ๋กฌ๋ณต์ด ํด๊ฒฐํด ์ฃผ๋๋ฐ, ๋กฌ๋ณต์ ์ฌ์ฉํ๋ฉด ๋ค์๊ณผ ๊ฐ์ ๋ชจ์ต์ด ๋ฉ๋๋ค.

<br />

```java
public class Member {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final int age;
    private final String country;

    @Builder
    private Member(String firstName, String middleName, String lastName, int age, String country) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.country = country;
    }
}
```

<br />

ํด๋์ค ๋ ๋ฒจ์ `@AllArgsConstructor`์ `@Builder`๋ฅผ ํจ๊ป ์ ์ธํ  ์๋ ์์ผ๋, ํด๋์ค ๋ณ์๋ก ์ปฌ๋ ์์ด ๋ค์ด๊ฐ๊ฑฐ๋ ํ๋ ๊ฒฝ์ฐ ๊ฐ์ฒด์ ์ด๊ธฐํ๊ฐ ์ ๋๋ก ๋์ง ์๋ ๋ฑ์ ์ด์๊ฐ ์์ด์ ๋ณดํต ์ด๋ฐ ๋ฐฉ์์ผ๋ก ์ฌ์ฉํฉ๋๋ค.

<br />

๋ง์ง๋ง์ผ๋ก ๋กฌ๋ณต์ ๋จ์ ์ด๋ผ๋ฉด ๋กฌ๋ณต์ ๋ฆฌํ๋ ์์ ํตํด ๋์ํ๊ธฐ ๋๋ฌธ์, ํ ๋ผ์ด๋ธ๋ฌ๋ฆฌ์์ ํธํ์ฑ ์ด์๊ฐ ์๊ธฐ๋ ๊ฒฝ์ฐ๊ฐ ๊ฐํน ์์ต๋๋ค.

<br />