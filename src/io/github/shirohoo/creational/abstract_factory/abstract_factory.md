# π μΆμ ν©ν λ¦¬ ν¨ν΄(Abstract Factory Pattern)

<br />

`μμ± ν¨ν΄` μ€ νλμΈ μΆμ ν©ν λ¦¬ ν¨ν΄μ μ΄λ€ μΆμνλ κ΅°μ§μ²΄λ₯Ό νλ²μ μμ±ν΄λ΄λ ν¨ν΄μ μλ―Έν©λλ€.

[ν€λ νΌμ€νΈ λμμΈ ν¨ν΄](http://www.kyobobook.co.kr/product/detailViewKor.laf?mallGb=KOR&ejkGb=KOR&barcode=9788979143409) μμλ μ΄ κ°λμ νΌμκ°κ²μμ μ¬λ¬ μ’λ₯μ νΌμλ₯Ό λ§λ€μ΄λ΄λ κ°λμΌλ‘ νμ΄μ μ€λͺν©λλ€.

μλ₯Ό λ€μ΄ νΌμκ°κ²μ μμΉ΄κ³  νΌμ, λνΈλ‘μ΄νΈ νΌμ, νμμ΄μ νΌμ λ±μ μ¬λ¬ νΌμκ° μλ€κ³  κ°μ νκ³ , κ³ κ°μ΄ μ΄λ€ νΌμλ₯Ό μ£Όλ¬Ένλ©΄ νλ²μ νΈμΆλ‘ κ·Έ νΌμλ₯Ό μμ±ν΄λ΄λ μμλλ€.

μ΄ μμ μμλ κ° λ°μ΄ν°λ² μ΄μ€ λ²€λλ³λ‘ λ°μ΄ν°λ² μ΄μ€μ μ κ·Όνλ `DAO`λ₯Ό μ¬λ¬κ° λκ³ , νλ²μ νΈμΆλ‘ λͺ¨λ  `μ½ν¬λ¦¬νΈ ν΄λμ€`λ₯Ό μμ±ν΄λ΄λ μμ λ₯Ό κ΅¬ννμ΅λλ€.

`ν΄λμ€ λ€μ΄μ΄κ·Έλ¨`μ λ€μκ³Ό κ°μ΅λλ€.

<br />

![class_diagram](Abstract_factory.PNG)

<br />

ν΄λΌμ΄μΈνΈλ μ€λ‘μ§ `RepositoryFactory`μ μμ μ΄ μ¬μ©νκ³ μ νλ λ°μ΄ν°λ² μ΄μ€λ§ μ λ¬νλ©΄, ν΄λΉ λ°μ΄ν°λ² μ΄μ€μ λ§κ² κ΅¬νλ λͺ¨λ  `DAO`λ₯Ό μ»μ μ μμ κ²λλ€.

<br  />

```java
// μΆμ ν©ν λ¦¬λ₯Ό μ μΈν©λλ€.
// μ΄ ν©ν λ¦¬λ ν΄λΌμ΄μΈνΈμ λ©μμ§λ₯Ό λ°μ κ° DAOλ₯Ό μμ±ν΄μ£Όλ μ±μμ κ°μ΅λλ€.
public interface RepositoryFactory {
    MemberRepository createMemberRepository();

    LectureRepository createLectureRepository();
}

public class MySQLRepositoryFactory implements RepositoryFactory {
    @Override
    public MemberRepository createMemberRepository() {
        return new MemberMySQLRepository();
    }

    @Override
    public LectureRepository createLectureRepository() {
        return new LectureMySQLRepository();
    }
}

public class OracleRepositoryFactory implements RepositoryFactory {
    @Override
    public MemberRepository createMemberRepository() {
        return new MemberOracleRepository();
    }

    @Override
    public LectureRepository createLectureRepository() {
        return new LectureOracleRepository();
    }
}

public interface LectureRepository {
    void insert(Lecture lecture);

    void select(Lecture lecture);

    void update(Lecture lecture);

    void delete(Lecture lecture);
}

public class LectureMySQLRepository implements LectureRepository {
    @Override
    public void insert(Lecture lecture) {
        System.out.println("MySQL :: insert :: " + lecture);
    }

    @Override
    public void select(Lecture lecture) {
        System.out.println("MySQL :: select :: " + lecture);
    }

    @Override
    public void update(Lecture lecture) {
        System.out.println("MySQL :: update :: " + lecture);
    }

    @Override
    public void delete(Lecture lecture) {
        System.out.println("MySQL :: delete :: " + lecture);
    }
}

public class LectureOracleRepository implements LectureRepository {
    @Override
    public void insert(Lecture lecture) {
        System.out.println("Oracle :: insert :: " + lecture);
    }

    @Override
    public void select(Lecture lecture) {
        System.out.println("Oracle :: select :: " + lecture);
    }

    @Override
    public void update(Lecture lecture) {
        System.out.println("Oracle :: update :: " + lecture);
    }

    @Override
    public void delete(Lecture lecture) {
        System.out.println("Oracle :: delete :: " + lecture);
    }
}

public interface MemberRepository {
    void insert(Member member);

    void select(Member member);

    void update(Member member);

    void delete(Member member);
}

public class MemberMySQLRepository implements MemberRepository {
    @Override
    public void insert(Member member) {
        System.out.println("MySQL :: insert :: " + member);
    }

    @Override
    public void select(Member member) {
        System.out.println("MySQL :: select :: " + member);
    }

    @Override
    public void update(Member member) {
        System.out.println("MySQL :: update :: " + member);
    }

    @Override
    public void delete(Member member) {
        System.out.println("MySQL :: delete :: " + member);
    }
}

public class MemberOracleRepository implements MemberRepository {
    @Override
    public void insert(Member member) {
        System.out.println("Oracle :: insert :: " + member);
    }

    @Override
    public void select(Member member) {
        System.out.println("Oracle :: select :: " + member);
    }

    @Override
    public void update(Member member) {
        System.out.println("Oracle :: update :: " + member);
    }

    @Override
    public void delete(Member member) {
        System.out.println("Oracle :: delete :: " + member);
    }
}
```

<br />

λ΄λΆ κ΅¬νμ λͺ¨λ μ΄λ€ λ©μλκ° μ€νλλμ§ μ λλ§ μμλ³Ό μ μκ² νμ€μΆλ ₯μ μ΄μ©νμμ΅λλ€.

κ·Έλ¦¬κ³  μ΄λ κ² μμ±ν μΆμ ν©ν λ¦¬λ₯Ό μ¬μ©νλ `Client`λ₯Ό μμ±ν©λλ€.

<br />

```java
import io.github.shirohoo.creational.abstract_factory.model.Lecture;

public class ConsoleRunner {
    private static final String DATABASE = "database";

    public static void main(String[] args) throws Exception {
        // μΆμ ν©ν λ¦¬μ μ¬μ©νκ³ μ νλ λ°μ΄ν°λ² μ΄μ€ λ²€λλ₯Ό μ λ¬ν©λλ€.
        RepositoryFactory factory = getFactory(readProperties().getProperty(DATABASE));

        memberCrud(createMember(), factory.createMemberRepository());

        System.out.println();

        lectureCrud(createLecture(), factory.createLectureRepository());
    }

    // μ λ¬λ°μ λ°μ΄ν°λ² μ΄μ€λ₯Ό ν λλ‘ μΆμ ν©ν λ¦¬μ ν΄λΉ λ°μ΄ν°λ² μ΄μ€ κ΅°μ§μ²΄ μμ±μ μμ²­ν©λλ€.
    private static RepositoryFactory getFactory(String database) {
        if (Objects.equals(database, DatabaseType.MYSQL.getDatabase())) {
            return new MySQLRepositoryFactory();
        }

        if (Objects.equals(database, DatabaseType.ORACLE.getDatabase())) {
            return new OracleRepositoryFactory();
        }

        throw new IllegalArgumentException("database not found !");
    }

    // νλ‘νΌν°μ μ μν λ°μ΄ν°λ² μ΄μ€λ₯Ό μ½μ΄μ΅λλ€.
    private static Properties readProperties() throws Exception {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("src/io/github/shirohoo/creational/abstract_factory/resources/application.properties");
        props.load(fis);
        return props;
    }

    private static Member createMember() {
        return Member.of("member@gmail.com", "password");
    }

    private static Lecture createLecture() {
        return Lecture.of(1L, "teacher", "title");
    }

    private static void lectureCrud(Lecture lecture, LectureRepository lectureRepository) {
        lectureRepository.insert(lecture);
        lectureRepository.select(lecture);
        lectureRepository.update(lecture);
        lectureRepository.delete(lecture);
    }

    private static void memberCrud(Member member, MemberRepository memberRepository) {
        memberRepository.insert(member);
        memberRepository.select(member);
        memberRepository.update(member);
        memberRepository.delete(member);
    }
}
```

<br />

μλ° μ½λλ μ ν λ³νκ² μμΌλ©°, μ€λ‘μ§ νλ‘νΌν° νμΌμμ μ΄λ€ λ°μ΄ν°λ² μ΄μ€λ₯Ό μ¬μ©ν μ§λ§ λ³κ²½νμκ³ , μ΄μ λ°λ₯Έ κ²°κ³Όλ λ€μκ³Ό κ°μ΅λλ€.

<br />

![image](https://user-images.githubusercontent.com/71188307/131424306-19ff6747-f7f8-48c2-aee3-c55a13bcbdc0.png)

<br />

![image](https://user-images.githubusercontent.com/71188307/131424315-e46c50aa-c3c2-48ad-8663-638a78fc10c2.png)

<br />

![image](https://user-images.githubusercontent.com/71188307/131424328-914ff956-2cc1-4b78-b134-5ec50c9471b3.png)

<br />

![image](https://user-images.githubusercontent.com/71188307/131424338-4cd89f85-d00b-4206-b8d0-ede92a8cf450.png)

<br />
