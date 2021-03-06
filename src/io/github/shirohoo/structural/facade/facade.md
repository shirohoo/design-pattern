# π νΌμ¬λ ν¨ν΄(Facade Pattern)

`νΌμ¬λ ν¨ν΄`μ `κ΅¬μ‘° ν¨ν΄` μ€ νλμ΄λ©°, μΈλΆλ‘ λΈμΆνλ μΈν°νμ΄μ€λ₯Ό λ¨μν νκΈ° μν λͺ©μ μ κ°λ λμμΈ ν¨ν΄μλλ€.

`Facade`μ μ¬μ μ  μ μλ `κ±΄λ¬Όμ μ λ©΄`μ μλ―Ένλ©°, κ°λ°μμ νΌμ¬λ ν¨ν΄μ `μν μ°½κ΅¬`μ λΉμ·νλ€κ³  μκ°νμλ©΄ λ  κ² κ°μ΅λλ€.

μν μ°½κ΅¬μμ νμμ΄ κ³ κ°μ μλνκ³  μμμ μμμ μμ²­λ°μΌλ©΄ λ€νΈ μ¬λ¬΄μ€μμλ λ§μ μΌλ€μ΄ μΌμ΄λμ£ .

<br />

κ°λ°λ‘ μλ₯Ό λ€μλ©΄, κ°λ°μλ€μ κ°λ°ν  λ IDEλ₯Ό μ¬μ©ν©λλ€.

κ·Έλ¦¬κ³  μ½λλ₯Ό μμ±ν ν μμ± ν μ½λλ₯Ό μ€νν  λ `Run` κ³Ό κ΄λ ¨λ λͺλ Ήμ΄λ₯Ό μλ ₯νκ±°λ, `μ΄λ‘μ νμ΄ν`μ κ°μ GUI μΈν°νμ΄μ€λ₯Ό νλ² ν΄λ¦­νλ λ±μ νμλ₯Ό ν©λλ€.

νΉμ μλ° μ½λλ₯Ό μμ±νκ³  `CLI` νκ²½μμ μ»΄νμΌ ν  κ²½μ° `javac` λͺλ Ήμ΄λ₯Ό ν΅ν΄ μλ° μ»΄νμΌλ¬λ₯Ό μ΄μ©νκΈ°λ νμ£ .

μ¦, μ΄λ κ² μ°λ¦¬λ μ΄λ€ νμλ₯Ό νκΈ° μν΄ λ¨ νλμ μΈν°νμ΄μ€λ§ μλ©΄ λ©λλ€.

μ°λ¦¬κ° μ΄ μΈν°νμ΄μ€λ₯Ό μ¬μ©νκ² λλ©΄ λμ λ³΄μ΄μ§ μλ κ³³μμ κ΅μ₯ν λ³΅μ‘ν, λ§μ μΌλ€μ΄ μΌμ΄λκ² λμ§λ§ μ°λ¦¬λ κ·Έλ¬ν μμλ€μ λν΄ λͺ°λΌλ μμ€νμ μ¬μ©νλλ° μλ¬΄λ° λ¬Έμ κ° μμ΅λλ€.

<br />

μ λ¦¬νμλ©΄ νΌμ¬λ ν¨ν΄μ μ¬μ©μ κ²½νμ ν° λμμ΄ λλ λμμΈ ν¨ν΄μ΄λΌκ³  ν  μ μκ² μ΅λλ€.

μ΄λ° κ°λμ μΈ λΆλΆμ λ¨Όμ  μ΄ν΄νμ  ν μμ  μ½λλ₯Ό λ³΄μλ©΄ μ’μ κ² κ°μλ°, μμ  μ½λκ° λΉλ‘ μΆμμ μ΄κΈ΄ νμ§λ§ [μν€λ°±κ³Όμ μμ](https://ko.wikipedia.org/wiki/%ED%8D%BC%EC%82%AC%EB%93%9C_%ED%8C%A8%ED%84%B4)κ° μμ£Ό μ μ νλ€κ³  μκ°ν΄ ν΄λΉ μ½λλ₯Ό μ²¨λΆν©λλ€.

<br />

# π  μμ  μ½λ

μλ `Java` μ½λ μμ λ `μ¬μ©μ(You)`κ° `νΌμ¬λ(Computer)`λ₯Ό ν΅ν΄ μ»΄ν¨ν° λ΄λΆμ λΆν(CPU, HDD)μ μ κ·Όνλ€λ λ΄μ©μ μΆμμ μΈ μμ μ΄λ€.

<br />

```java
/* Complex parts */

class CPU {
	public void freeze() { ... }
	public void jump(long position) { ... }
	public void execute() { ... }
}

class Memory {
	public void load(long position, byte[] data) {
		...
	}
}

class HardDrive {
	public byte[] read(long lba, int size) {
		...
	}
}

/* FaΓ§ade */

class Computer {
	public void startComputer() {
        CPU cpu = new CPU();
        Memory memory = new Memory();
        HardDrive hardDrive = new HardDrive();
		cpu.freeze();
		memory.load(BOOT_ADDRESS, hardDrive.read(BOOT_SECTOR, SECTOR_SIZE));
		cpu.jump(BOOT_ADDRESS);
		cpu.execute();
	}
}

/* Client */

class You {
	public static void main(String[] args) throws ParseException {
		Computer facade = /* grab a facade instance */;
		facade.startComputer();
	}
}/* Complex parts */

class CPU {
	public void freeze() { ... }
	public void jump(long position) { ... }
	public void execute() { ... }
}

class Memory {
	public void load(long position, byte[] data) {
		...
	}
}

class HardDrive {
	public byte[] read(long lba, int size) {
		...
	}
}

/* FaΓ§ade */

class Computer {
	public void startComputer() {
        CPU cpu = new CPU();
        Memory memory = new Memory();
        HardDrive hardDrive = new HardDrive();
		cpu.freeze();
		memory.load(BOOT_ADDRESS, hardDrive.read(BOOT_SECTOR, SECTOR_SIZE));
		cpu.jump(BOOT_ADDRESS);
		cpu.execute();
	}
}

/* Client */

class You {
	public static void main(String[] args) throws ParseException {
		Computer facade = /* grab a facade instance */;
		facade.startComputer(); // μ¬μ©μλ νΌμ¬λ κ°μ²΄κ° μ κ³΅νλ μΈν°νμ΄μ€λ§ νΈμΆνλ©΄ λλ€. 
	}
}
```

<br />