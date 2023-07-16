public class DIP {
    public interface iEngine {
        public void start();

        public void stop();

        public String getType();

    }

    public class Car {
        private iEngine engine;

        public Car(iEngine engine) {
            this.engine = engine;
        }

        public String getType() {
           
            return engine.getType();
        }

        public void start() {
            this.engine.start();
        }

        public void stop() {
            this.engine.stop();
        }
    }

    public class PetrolEngine implements iEngine {
        String type = "Бензиновый";

        @Override
        public void start() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'start'");
        }

        @Override
        public void stop() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'stop'");
        }

        @Override
        public String getType() {
            return type;
        }

    }

    public class DiselEngine implements iEngine {
        String type = "Дизельный";

        @Override
        public void start() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'start'");
        }

        @Override
        public void stop() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'stop'");
        }

        @Override
        public String getType() {
            return type;
        }

    }
}
