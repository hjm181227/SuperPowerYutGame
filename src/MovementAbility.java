public class MovementAbility {

    public static class MoOrDo extends Ability{
        @Override
        public void use() {
            //모 아니면 도
        }
    }

    public static class GaeOrGirl extends Ability{
        @Override
        public void use() {
            //개 아니면 걸
        }
    }

    public static class BackStep extends Ability{
        @Override
        public void use() {
            //던진 윷만큼 뒤로 가기
        }
    }

    public static class OnlyYut extends Ability{
        @Override
        public void use(){
            //던지면 무조건 윷
        }
    }

}
