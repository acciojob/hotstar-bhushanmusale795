package com.driver.model;


    public class Match {
        private String teamA;
        private String teamB;

        public Match(String teamA, String teamB) {
            this.teamA = teamA;
            this.teamB = teamB;
        }

        public String getMatchInfo() {
            return teamA + " vs " + teamB;

    }

}
