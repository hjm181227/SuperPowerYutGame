import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MovementAbility {

    public static class MoOrDo extends Ability{
        //모 아니면 도
        int randomNum;
        @Override
        public void use() {
            randomNum= (int)(Math.random()*2);
            System.out.println("MD randomNum >>" + randomNum);
            if(randomNum==0){ _data.throwResult = 5;   }            //모
            else{ _data.throwResult = 1;   }                        //도
        }
    }



    public static class GaeOrGirl extends Ability{
        //개 아니면 걸
        int randomNum;
        @Override
        public void use() {
            randomNum= (int)(Math.random()*2);
            System.out.println("GG randomNum >>" + randomNum);
            if(randomNum==0){ _data.throwResult = 2;   }            //개
            else{ _data.throwResult = 3;   }                        //걸
        }
    }

    public static class OnlyYut extends Ability{
        //던지면 무조건 윷
        @Override
        public void use(){
            System.out.println("only yut");
            _data.throwResult=4;
        }
    }

}
