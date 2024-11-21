class Warrior {
    public static void Attack(String name, String wepon) {
        System.out.println(name + "(이)가 " + wepon + "(으)로 공격합니다.");
    }
    
}

public class Ex_001 {

    public static void main(String[] args) {
        Warrior aWarrior = new Warrior();

        aWarrior.Attack("NRKim", "Sworld");

    }
}
