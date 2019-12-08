import com.sun.jnlp.JNLPRandomAccessFileNSBImpl;
import sun.security.krb5.internal.crypto.Des;

public class LocationAbility {


    public static class GoHome extends Ability{
        @Override
        public void use() {
            //상대 말 하나 집으로 보내기

        }
    }

    public static class UpSideDown extends Ability {
        public int[] Destination = new int [8];
        @Override
        public void use() {

            //밥상뒤집기
            UpSide(_data.leftPlayer);
            UpSide(_data.rightPlayer);

        }

        public void UpSide(Player Player)
        {
            int[] CurrentIdx = new int[8];
            int PawnCount = 0;
            int i = 0, j = 0, flag = 0, RandomIdx;
            for (Pawn p : Player.pawns) {
                if (p.isFinished() == false && p.getCurrentIndex() != 0) {
                    for (j = 0, flag = 0; j < PawnCount; j++) {
                        if (CurrentIdx[j] == p.getCurrentIndex())
                            flag = 1;
                    }
                    if (flag == 0)
                        CurrentIdx[PawnCount++] = p.getCurrentIndex();
                }
            }
            for(i = 0 ; i < PawnCount; i++) {
                while (true) {
                    RandomIdx = (int) (Math.random() * 29) + 1;
                    for (j = 0, flag = 0; j < i; j++) {
                        if (Destination[i] == Destination[j])
                            flag = 1;
                    }
                    if (flag == 0) {
                        Destination[i] = RandomIdx;
                        break;
                    }
                }
            }
            System.out.println(">>>>>>>>>>>>" + i +"<<<<<<<<<<");
            for(i = 0; i < PawnCount; i++)
            {

                System.out.println(CurrentIdx[i]);
                System.out.println(">>"+Destination[i]+"<<");

                _data.moveAllPawns(Player, CurrentIdx[i], Destination[i]);
            }
        }

        public static class Exchange extends Ability {
            @Override
            public void use() {
                //상대 말과 자리바꾸기
            }
        }
    }

    public static class Exchange extends Ability {
        @Override
        public void use() {
            //상대 말과 자리바꾸기
        }
    }
}

