package com.javaworld.javachallengers.equalshashcode.challenge;

import java.util.*;

public class EqualsHashCodeChallenge {

    public static void main(String... doYourBest) {
        System.out.println(new Simpson("Bart").equals(new Simpson("Bart")));
        Simpson overriddenHomer = new Simpson("Homer") {
            public int hashCode() {
                return (43 + 777) + 1;
            }
        };

        System.out.println(new Simpson("Homer").equals(overriddenHomer));

        var set = Set.of(new Simpson("Homer"), new Simpson("Marge"));
        set.add(new Simpson("Homer"));
        set.add(overriddenHomer);

        System.out.println(set.size());
    }

    static class Simpson {
        String name;

        Simpson(String name) {
            this.name = name;
        }
/*
        @Override
        public boolean equals(Object obj) {
            Simpson otherSimpson = (Simpson) obj;
            return this.name.equals(otherSimpson.name) &&
                    this.hashCode() == otherSimpson.hashCode();
        }

        @Override
        public int hashCode() {
            return (43 + 777);
        }
*/

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            //if (o == null || getClass() != o.getClass()) return false;
            if ((hashCode()!=o.hashCode()) || (o == null || getClass() != o.getClass())) return false;
            Simpson simpson = (Simpson) o;

            return name.equals(simpson.name);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }
    }

}
