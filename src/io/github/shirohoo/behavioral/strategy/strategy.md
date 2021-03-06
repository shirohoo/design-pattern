# π μ λ΅ ν¨ν΄(Strategy Pattern) νΉμ μ μ± ν¨ν΄(Policy Pattern)

<br />

`νμ ν¨ν΄`μ μνλ `μ λ΅ ν¨ν΄`μλλ€.

λκ΅°κ°λ `μ μ± ν¨ν΄`μ΄λΌκ³ λ λΆλ₯΄κΈ°λ ν©λλ€λ§, λμ²΄μ μΌλ‘ μ λ΅ ν¨ν΄μ΄λΌλ μ΄λ¦μΌλ‘ λ μ μλ €μ Έμμ΅λλ€.

νΉμλ `λμμΈ ν¨ν΄μ κ½`μ΄λΌκ³  λΆλ₯΄κΈ°λ ν  μ λλ‘ μμ£Ό μ¬μ°λ©΄μλ λλ¦¬ μ¬λλ°κ³ , μ¬μ©λκ³  μλ κ°λ ₯ν ν¨ν΄μλλ€.

<br >

λμμΈ ν¨ν΄μ νλ§λλ‘ μ½κ² μ μνλκ²μ λ§€μ° μ΄λ ΅μ§λ§, μ λ΅ ν¨ν΄μ μ¬μ©νλ μ΄μ μ λν΄ ν΅μ¬λ§ λ¨Όμ  λ§μλλ¦¬μλ©΄...!

<br />

`μ΄λ ν μ²λ¦¬ λ°©λ²(=μκ³ λ¦¬μ¦)μ μΊ‘μννκ³ , μ΄κ²μ νΉμ  κ°μ²΄μ μνλ‘ μ¬μ©νλ©° μ΄λ₯Ό λ°νμμ μ μ°νκ² λ³κ²½νλ κ²`μ λͺ©μ μ λ‘λλ€.

[ν€λνΌμ€νΈ λμμΈν¨ν΄](https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=582754) μμλ μ€λ¦¬κ° λλ€, μλ¬΄κ²λ μνλ€ λ±μΌλ‘ λΉμ νκ³  μμ΅λλ€.

μ€μ λ‘ μ¬μ©ν΄λ³Όλ§ν μλ₯Ό μκ°ν΄λ³΄μλ©΄, μ½μΌν°μμ λ¬Έμμ νλ₯Ό λ°λλ°, λ¬Έμμ νλ₯Ό μ΄λ€ λ°©μμΌλ‘ μλ΄μλ€μκ² λλ €μ€μ§λΌλκ°, κ²μμ λ§λλλ° μΌλ¦­ν°μ μ§μμ λ°λΌ μ€ν¬μ΄ λ°λλ€λκ° νλ κ²λ€μ μ μ©ν΄λ³Ό μ μμ κ² κ°μ΅λλ€.

<br />

![image](https://user-images.githubusercontent.com/71188307/133035797-e53b96bc-6e7f-454d-a524-7d56eee9b724.png)

μΆμ² - μν€λ°±κ³Ό

<br />

## π  κ΅¬ν

μ­μ κ΄λ ¨ μν°ν΄μ λ³΄λ€λ³΄λ©΄ μ¬λ¬κ°μ§ κ΅¬ν λ°©μμ΄ μμ§λ§, ν΅μ¬μ `μΈν°νμ΄μ€`λ₯Ό μ¬μ©ν΄ μκ³ λ¦¬μ¦μ μΊ‘μν νλ κ²μλλ€.

μ¬κΈ°κΉμ§ μ΄ν΄νλ€λ©΄ μ΄ν μμ©μ λ³ΈμΈ νκΈ° λλ¦μ΄κ² μ£ ?

μ λ μ΄λ²μλ μ­μ DB κ΅¬νμ²΄λ₯Ό μ΄μ©ν΄ μμ λ₯Ό μμ±νμ΅λλ€.

ν΄λΌμ΄μΈνΈκ° μ€λΌν΄μ μ¬μ©νλ€κ° κ°μκΈ° MySQLμ μ¬μ©νκ³  μΆλ€κ³  νλ€λ©΄, μ λ΅ ν΄λμ€λ§ κ°μλΌμ μ μ°νκ² λ³κ²½ν  μ μμκ²λλ€.***(μ€μ  μ΄λ° κ²½μ°λ μλ§λ μμ΅λλ€ π)***

<br />

μ°μ  μ λ΅ ν΄λμ€λ₯Ό μ μν©λλ€.

<br />

```java
public interface DBConnector {
    void connect();
}

public final class MySQLConnector implements DBConnector {
    @Override
    public void connect() {
        System.out.println("connected to MySQL");
    }
}

public final class OracleConnector implements DBConnector {
    @Override
    public void connect() {
        System.out.println("connected to Oracle");
    }
}
```

<br />

μ λ΅ ν΄λμ€λ₯Ό μ¬μ© νκΈ° μν κ°μ²΄λ μ μν΄μ€λλ€.

<br />

```java
public enum Databases {
    MYSQL(MySQLConnector::new),
    ORACLE(OracleConnector::new);
    private final Supplier<DBConnector> supplier;

    Databases(Supplier<DBConnector> supplier) {
        this.supplier = supplier;
    }

    public DBConnector createConnector() {
        return supplier.get();
    }
}

public final class Connector {
    private final DBConnector dbConnector;

    private Connector(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    public static Connector from(Databases databases) {
        return new Connector(databases.createConnector());
    }

    public void connect() {
        dbConnector.connect();
    }
}
```

<br />

```java
public class ConsoleRunner {
    public static void main(String[] args) {
        Connector mysql = Connector.from(Databases.MYSQL);
        mysql.connect();

        Connector oracle = Connector.from(Databases.ORACLE);
        oracle.connect();
    }
}
```

<br />

μ²μ `Connector` κ°μ²΄λ₯Ό μμ±ν  λ `Oracle`μ μ£Όμλ°μ μμ±νκ³ , μ΄ν μ»€λ₯ν°λ₯Ό `MySQL`λ‘ λ³κ²½νμ΅λλ€.

κ·Έλ¦¬κ³  μ΄λ¬ν λ³κ²½μ μ λ΅ ν¨ν΄μ μ μ©ν¨μΌλ‘μ μ΄λ κ² μ½κ² λλ  μ μμ΅λλ€.

κ²°κ³Όλ λ€μκ³Ό κ°μ΅λλ€.

<br />

```shell
connected to MySQL
connected to Oracle
```

<br />
