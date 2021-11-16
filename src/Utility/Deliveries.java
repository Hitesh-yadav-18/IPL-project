package Utility;

public class Deliveries {

        private int match_id;
        private int inning;
        private String batting_team;
        private String bowling_team;
        private int over;
        private int ball;
        private String batsman;
        private  String non_striker;
        private String bowler;
        private int is_super_over;
        private int wide_runs;
        private int bye_runs;
        private int legbye_runs;
        private int noball_runs;
        private int panelty_runs;
        private int batsman_runs;
        private int extra_runs;
        private int total_runs;
        private String player_dismissed;
        private String dismissal_kind;
        private String fielder;



        public int getMatch_id() {
                return match_id;
        }

        public void setMatch_id(int match_id) {
                this.match_id = match_id;
        }

        public int getInning() {
                return inning;
        }

        public void setInning(int inning) {
                this.inning = inning;
        }

        public String getBatting_team() {
                return batting_team;
        }

        public void setBatting_team(String batting_team) {
                this.batting_team = batting_team;
        }

        public String getBowling_team() {
                return bowling_team;
        }

        public void setBowling_team(String bowling_team) {
                this.bowling_team = bowling_team;
        }

        public int getOver() {
                return over;
        }

        public void setOver(int over) {
                this.over = over;
        }

        public int getBall() {
                return ball;
        }

        public void setBall(int ball) {
                this.ball = ball;
        }

        public String getBatsman() {
                return batsman;
        }

        public void setBatsman(String batsman) {
                this.batsman = batsman;
        }

        public String getNon_striker() {
                return non_striker;
        }

        public void setNon_striker(String non_striker) {
                this.non_striker = non_striker;
        }

        public String getBowler() {
                return bowler;
        }

        public void setBowler(String bowler) {
                this.bowler = bowler;
        }

        public int getIs_super_over() {
                return is_super_over;
        }

        public void setIs_super_over(int is_super_over) {
                this.is_super_over = is_super_over;
        }

        public int getWide_runs() {
                return wide_runs;
        }

        public void setWide_runs(int wide_runs) {
                this.wide_runs = wide_runs;
        }

        public int getBye_runs() {
                return bye_runs;
        }

        public void setBye_runs(int bye_runs) {
                this.bye_runs = bye_runs;
        }

        public int getLegbye_runs() {
                return legbye_runs;
        }

        public void setLegbye_runs(int legbye_runs) {
                this.legbye_runs = legbye_runs;
        }

        public int getNoball_runs() {
                return noball_runs;
        }

        public void setNoball_runs(int noball_runs) {
                this.noball_runs = noball_runs;
        }

        public int getPanelty_runs() {
                return panelty_runs;
        }

        public void setPanelty_runs(int panelty_runs) {
                this.panelty_runs = panelty_runs;
        }

        public int getBatsman_runs() {
                return batsman_runs;
        }

        public void setBatsman_runs(int batsman_runs) {
                this.batsman_runs = batsman_runs;
        }

        public int getExtra_runs() {
                return extra_runs;
        }

        public void setExtra_runs(int extra_runs) {
                this.extra_runs = extra_runs;
        }

        public int getTotal_runs() {
                return total_runs;
        }

        public void setTotal_runs(int total_runs) {
                this.total_runs = total_runs;
        }

        public String getPlayer_dismissed() {
                return player_dismissed;
        }

        public void setPlayer_dismissed(String player_dismissed) {
                this.player_dismissed = player_dismissed;
        }

        public String getDismissal_kind() {
                return dismissal_kind;
        }

        public void setDismissal_kind(String dismissal_kind) {
                this.dismissal_kind = dismissal_kind;
        }

        public String getFielder() {
                return fielder;
        }

        public void setFielder(String fielder) {
                this.fielder = fielder;
        }

        @Override
        public String toString() {
                return "Deliveries{" +
                        "match_id=" + match_id +
                        ", inning=" + inning +
                        ", batting_team='" + batting_team + '\'' +
                        ", bowling_team='" + bowling_team + '\'' +
                        ", over=" + over +
                        ", ball=" + ball +
                        ", batsman='" + batsman + '\'' +
                        ", non_striker='" + non_striker + '\'' +
                        ", bowler='" + bowler + '\'' +
                        ", is_super_over=" + is_super_over +
                        ", wide_runs=" + wide_runs +
                        ", bye_runs=" + bye_runs +
                        ", legbye_runs=" + legbye_runs +
                        ", noball_runs=" + noball_runs +
                        ", panelty_runs=" + panelty_runs +
                        ", batsman_runs=" + batsman_runs +
                        ", extra_runs=" + extra_runs +
                        ", total_runs=" + total_runs +
                        ", player_dismissed='" + player_dismissed + '\'' +
                        ", dismissal_kind='" + dismissal_kind + '\'' +
                        ", fielder='" + fielder + '\'' +
                        '}';
        }
}
