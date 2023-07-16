public class OCP {

    public class SpeedCalculation {
        public double calculateAllowedSpeed(Vehicle vehicle) {
            return vehicle.getRealSpeed();
        }
    }

    public class Vehicle {
        int maxSpeed;
        String type;
        double speedFactor; // от 0 до 1

        public Vehicle(int maxSpeed, double speedFactor, String type) {
            this.maxSpeed = maxSpeed;
            this.type = type;
            this.speedFactor = speedFactor;
        }

        public int getMaxSpeed() {
            return this.maxSpeed;
        }

        public String getType() {
            return this.type;
        }

        public double getRealSpeed() {
            return this.getMaxSpeed() * speedFactor;
        }

    }

    public class eBus extends Vehicle {

        /**
         * @param maxSpeed
         * @param realSpeed от 0 до 1
         * @param type
         */
        public eBus(int maxSpeed, Double speedFactor, String type) {
            super(maxSpeed, speedFactor, type);
            // TODO Auto-generated constructor stub
        }

    }

    public class eCar extends Vehicle {

        /**
         * @param maxSpeed
         * @param realSpeed от 0 до 1
         * @param type
         */
        public eCar(int maxSpeed, Double speedFactor, String type) {
            super(maxSpeed, speedFactor, type);
            // TODO Auto-generated constructor stub
        }

    }
}
