abstract class Weapons {
    String Weapon;
}

class Weapon extends Weapons {
    public String Swrorld(int selFlg) {
        switch (selFlg) {
            case 1 : 
                return "전설의 검";
            
            case 2 : 
                return "준전설의 검";
    
            case 3 :
                return "그냥 검";
    
            default:
                return "맨손";
        }
    }

    public String Bow(int selFlg) {
        switch (selFlg) {
            case 1 : 
                return "전설의 활";
            
            case 2 : 
                return "준전설의 활";
    
            case 3 :
                return "일반 활";
    
            default:
                return "맨손";
        }
    }    
}

class Worrior {
    String name;
    int age;
    Weapon aWeapon; 
    public void Attack(int ages, String names,String weapon) {
        System.out.println(ages+" 살 전사 " + names + " (이)가 " + weapon + " (으)로 공격합니다. ");
    }
    
}

public class Ex_002 {

    public static void main(String[] args) {
        Worrior aWorrior = new Worrior();
        aWorrior.name = "카니";
        aWorrior.age = 22;
        aWorrior.aWeapon = new Weapon();
        String wepon = aWorrior.aWeapon.Swrorld(1);
        
        aWorrior.Attack(aWorrior.age,aWorrior.name,wepon);

        aWorrior.name = "초코";
        aWorrior.age = 42;
        aWorrior.aWeapon = new Weapon();
        wepon = aWorrior.aWeapon.Bow(4);
        
        aWorrior.Attack(aWorrior.age,aWorrior.name,wepon);

    }
}