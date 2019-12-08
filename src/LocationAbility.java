import com.sun.jnlp.JNLPRandomAccessFileNSBImpl;

public class LocationAbility {


    public static class GoHome extends Ability{
        @Override
        public void use() {
            //상대 말 하나 집으로 보내기

        }
    }

    public static class UpSideDown extends Ability {
        public int[] CurrentIdx = new int[8];
        public int[] Destination = new int [8];
        private int PawnCount = 0;
        private int i = 0, j = 0, flag = 0, RandomIdx;

        @Override
        public void use() {
            //밥상뒤집기
            for (Pawn p : _data.leftPlayer.pawns) {
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
                RandomIdx = ((int) Math.random() * 29) + 1;
                while (true) {
                    for (j = 0, flag = 0; j < i; j++) {
                        if (Destination[i] == Destination[j])
                            flag = 1;
                    }
                    if (flag == 0)
                        Destination[i] = RandomIdx;
                }
            }
            for(i = 0; i < PawnCount; i++)
            {
                System.out.println(CurrentIdx[i] + Destination[i]);
            }
        }

        public static class Exchange extends Ability {
            @Override
            public void use() {
                //상대 말과 자리바꾸기
            }
        }
    }
}

