public class Hero {
        private final String name;
        private final Power[] powers;


        public Hero(String name, Power[] powers) {
            this.name = name;
            this.powers = powers;
        }


        public String getName() {
            return name;
        }

        public Power[] getPowers() {
            return powers;
        }
        public String toLine() {
            StringBuilder result = new StringBuilder();

            result.append(name).append(": ");

            for (Power p : powers) {
                result.append(p.getName()).append(", ");
            }
            return result.toString();
        }


    }
