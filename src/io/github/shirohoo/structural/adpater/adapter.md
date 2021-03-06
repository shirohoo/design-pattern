# π μ΄λν° ν¨ν΄(Adapter Pattern)

<br />

`μ΄λν° ν¨ν΄`μ `κ΅¬μ‘° ν¨ν΄` μ€ νλμ΄λ©°, `μΈν°νμ΄μ€ νΈν`μ μν λμμΈ ν¨ν΄μλλ€.

`μΈν°νμ΄μ€ νΈν`μ λν΄ μ΄ν΄νμ§ λͺ»νλ€λ©΄ μΆνμ μ΄λν° ν¨ν΄μ `λ°μ½λ μ΄ν° ν¨ν΄`, `νλ‘μ ν¨ν΄`λ±κ³Ό ν·κ°λ¦΄ μλ μμ΅λλ€.

<br />

## π‘ μλλ¦¬μ€

- 110Vμ 220Vλ₯Ό μ¬μ©νλ κ°μ μ νμ΄ μμ΅λλ€.
- λ κ°μ  μ νμ μ κ²©μ μμ΄ λ€λ₯΄κΈ° λλ¬Έμ μλ‘ λ€λ₯Έ μμΌμ μ¬μ©ν΄μΌλ§ ν©λλ€.
- νμ§λ§ λ κ°μ  μ νμ νλμ μμΌμΌλ‘ μ¬μ©νκ³  μΆμ΅λλ€.

<br />

```java
public interface Electronic220V {
    void on();
}

public class AirConditioner implements Electronic220V {
    @Override
    public void on() {
        System.out.println("220V - μμ΄μ»¨");
    }
}
```

<br />

```java
public interface Electronic110V {
    void on();
}

public class HairDryer implements Electronic110V {
    @Override
    public void on() {
        System.out.println("110V - ν€μ΄ λλΌμ΄κΈ°");
    }
}
```

<br />

```java
public class Socket110V {
    public static void connect(Electronic110V electronic110V) {
        electronic110V.on();
    }
}
```

<br />

```java
public class ConsoleRunner {
    public static void main(String[] args) {
        HairDryer hairDryer = new HairDryer();
        Socket110V.connect(hairDryer);
    }
}

public class ConsoleRunner {
    public static void main(String[] args) {
        // Socket110V.connect()κ° 110Vλ§ μλ ₯λ°μ μ μκΈ° λλ¬Έμ μ΄ μ½λλ μ»΄νμΌ μλ¬ λ°μ.
        // 110Vμ 220Vλ₯Ό νΈνμμΌμ€ μ μλ μ΄λν°κ° νμνλ€.
        AirConditioner airConditioner = new AirConditioner();
        Socket110V.connect(airConditioner); // λΆκ°
    }
}
```

<br />

110Vμ 220Vλ₯Ό νΈνν΄μ€ μ μλ μ΄λν°λ₯Ό μμ±ν©λλ€.

<br />

```java
public class Adapter implements Electronic110V {
    private final Electronic220V electronic220V;

    private Adapter(Electronic220V electronic220V) {
        this.electronic220V = electronic220V;
    }

    public static Adapter from(Electronic220V electronic220V) {
        return new Adapter(electronic220V);
    }

    @Override
    public void on() {
        System.out.println("220V -> 110V μ»¨λ²νΈ !");
        electronic220V.on();
    }
}
```

<br />

μ΄ μ΄λν°λ μ΄μ  μ΄λ κ² μ¬μ©ν  μ μμ΅λλ€.

<br />

```java
public class ConsoleRunner {
    public static void main(String[] args) {
        Adapter adapter = Adapter.from(new AirConditioner());
        Socket110V.connect(adapter);
    }
}
```

<br />

μΆλ ₯μ λ€μκ³Ό κ°μ΅λλ€.

<br />

```shell
220V -> 110V μ»¨λ²νΈ !
220V - μμ΄μ»¨
```

<br />

# μ¬μ©μ² ?

μλ° SDKμμ μ΄λν° ν¨ν΄μ΄ μ μ©λ μμ λΌκ³  νλ©΄ `InputStreamReader` κ° μμ΅λλ€.

<br />

![image](https://user-images.githubusercontent.com/71188307/133993951-0fa374c6-ad0a-43b7-afde-97d01d921e4c.png)


<br />

μΈμλ μ£Όλ‘ νμ€ μμΆλ ₯κ³Ό κ΄κ³λ λΌμ΄λΈλ¬λ¦¬μ `μ΄λν° ν¨ν΄`, `λ°μ½λ μ΄ν° ν¨ν΄`λ±μ΄ λ§μ΄ μ¬μ©λμ΅λλ€.

<br />

```java
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
```

<br />

`BufferedReader`μ μμ±μ μ½λλ₯Ό κΉλ³΄λ©΄ λ€μκ³Ό κ°μ΅λλ€.

<br />

```java
public BufferedReader(Reader in){
        this(in,defaultCharBufferSize);
        }
```

<br />

νλΌλ―Έν°λ‘ `Reader` νμμ λ°λλ°,  `System.in`μ `InputStream` νμμ λ°ννλ―λ‘ μλ νΈνλμ§ μμμΌ μ μμλλ€.

<br />

```java
public final static InputStream in=null;
```

<br />

νμ§λ§ μ¬κΈ°μ `InputStreamReader`λΌλ, `InputStream`μ μλ ₯λ°μ `Reader` νμμ λ°νν΄μ£Όλ μ΄λν° ν΄λμ€λ₯Ό μ μ©νλ―λ‘μ¨ νΈνμ΄ κ°λ₯ν΄μ§λλ€.

<br />

```java
public class InputStreamReader extends Reader { // InputStreamReader λ Reader λ₯Ό μμλ°μ΅λλ€.
    public InputStreamReader(InputStream in) {
        super(in);
        sd = StreamDecoder.forInputStreamReader(in, this, Charset.defaultCharset()); // ## check lock object
    }
}
```

<br />
