# π μν ν¨ν΄(State Pattern)

`νμ ν¨ν΄`μ μνλ `μν ν¨ν΄`μλλ€.

ν΄λμ€μ λ΄λΆ μνμ λ°λΌ ν΄λμ€κ° νλ μΌμ΄ λ°λλ κ²μ λͺ©μ μΌλ‘ ν©λλ€.

μ΄λ₯Ό μν ν¨ν΄μ μ μ©νμ§ μκ³  μ§μ  κ΅¬ν ν  κ²½μ° `if/else` λ¬Έμ΄ κ΅μ₯ν λ§μ΄ μ¬μ©λκ² λ©λλ€.

μ΄λ κ² μ‘°κ±΄λ¬Έμ΄ λ§μμ§κ² λλ©΄ μ½λλ₯Ό λ΄€μ λ νλμ λ¬΄μ¨ μμμ νκ³  μλμ§ μμλ³΄κΈ° νλ­λλ€. μ¦, κ°λμ±μ΄ μΌλ¨ λ¨μ΄μ§λλ€.

λν, μκ΅¬μ¬ν­μ΄ λ³κ²½λμ΄ μ½λλ₯Ό μμ ν΄μΌ ν  κ²½μ° μ μ§λ³΄μμ±λ λ¨μ΄μ§κ² λ©λλ€.

μ½λ©μ νλ€λ³΄λ©΄ μ‘°κ±΄λ¬Έμ μμ μμΈμλ μμ§λ§, μ΅λν μ¬μ©νμ§ μλ λ°©ν₯μΌλ‘ μ½λ©νλ κ²μ΄ μ€μν κ² κ°μ΅λλ€.

<br />

## π  κ΅¬ν

<br />

![image](https://user-images.githubusercontent.com/71188307/136762407-4b3ac575-cd2e-426f-a899-b3e1678411dc.png)

<br />

μ»΄ν¨ν°μ μ μμ΄ μΌμ Έμλμ§, κΊΌμ Έμλμ§μ λ°λΌ λ€λ₯Έ λμμ νκ²λ νκ³  μΆλ€κ³  κ°μ νκ² μ΅λλ€.

λ¨Όμ  μ»΄ν¨ν°μ μνλ₯Ό μμ±ν©λλ€.

<br />

```java
public interface PowerState {
    void powerOperate();
}

public class PowerOn implements PowerState {
    @Override
    public void powerOperate() {
        System.out.println("Power off.");
    }
}

public class PowerOff implements PowerState {
    @Override
    public void powerOperate() {
        System.out.println("Power on.");
    }
}
```

<br />

κ·Έλ¦¬κ³  κ΅¬νν μνλ₯Ό μ¬μ©νλ μ»΄ν¨ν°λ₯Ό μμ±ν©λλ€.

<br />

```java
public class Computer {
    private PowerState powerState;

    private Computer(PowerState powerState) {
        this.powerState = powerState;
    }

    public static Computer from(PowerState powerState) {
        return new Computer(powerState);
    }

    public void changePowerState(PowerState powerState) {
        this.powerState = powerState;
    }

    public void powerOperate() {
        powerState.powerOperate();
    }
}
```

<br />

μμ±ν μ»΄ν¨ν°λ₯Ό μ¬μ©ν΄λ³΄λ©΄...

<br />

```java
public class ConsoleRunner {
    public static void main(String[] args) {
        // μ»΄ν¨ν°κ° κΊΌμ§ μνλ‘ μ΄κΈ°ν
        Computer computer = Computer.from(new PowerOff());

        computer.powerOperate(); // Power on. μΆλ ₯
        computer.changePowerState(new PowerOn()); // μ»΄ν¨ν°κ° μΌμ§ μνλ‘ λ³κ²½

        computer.powerOperate(); // Power off. μΆλ ₯
        computer.changePowerState(new PowerOff()); // μ»΄ν¨ν°κ° κΊΌμ§ μνλ‘ λ³κ²½
    }
}
```

<br />

```shell
Power on.
Power off.
```

<br />

μ»΄ν¨ν°μ μ μ μνμ μ μ λͺ¨λ λ±μ΄ μΆκ°λλλΌλ, μ μ λͺ¨λλ₯Ό νννλ ν΄λμ€λ§ νλ μΆκ°νλ©΄ λ§€λλ¬μ΄ νμ₯μ΄ κ°λ₯ν΄μ§λλ€.

λν, κ° μνκ° ν΄λμ€λ‘ λΆλ¦¬λμ΄μκΈ° λλ¬Έμ, νΉμ  μνλ§ λ³κ²½νκ³ μ νλ©΄ ν΄λΉ μνλ₯Ό νννλ ν΄λμ€λ§ μ§μ€μ μΌλ‘ μ΄ν΄λ³΄λ©΄ λκ² λ©λλ€.

μ΄λ κ² μν ν¨ν΄μ μ‘°κ±΄λ¬Έμ νκΈ°μ μΌλ‘ μ€μ΄λ©΄μλ μ μ§λ³΄μνκΈ° μ’μ μ½λλ₯Ό λ§λ€ μ μκ² ν΄μ€λλ€.

μ λ΅ ν¨ν΄κ³Ό μμ£Ό μ μ¬νλ°, μ λ΅ ν¨ν΄μ μμμ μ€μ΄κΈ° μν λͺ©μ μΌλ‘ μ¬μ©λκ³ , μν ν¨ν΄μ μ‘°κ±΄λ¬Έμ μ€μ΄κΈ° μν λͺ©μ μΌλ‘ μ¬μ©λ©λλ€.

<br />
