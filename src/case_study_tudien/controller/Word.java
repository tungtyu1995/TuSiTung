package case_study_tudien.controller;

import java.io.Serializable;

public class Word implements Serializable {
    private String action;
    private String pronoun;
    private String adjective;
    private String noun;
    private String verb;
    private String synonymous;

    public Word() {
    }

    public Word(String action, String pronoun, String adjective, String noun,
                String verb, String synonymous) {
        this.action = action;
        this.pronoun = pronoun;
        this.adjective = adjective;
        this.noun = noun;
        this.verb = verb;
        this.synonymous = synonymous;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getPronoun() {
        return pronoun;
    }

    public void setPronoun(String pronoun) {
        this.pronoun = pronoun;
    }

    public String getNoun() {
        return noun;
    }

    public void setNoun(String noun) {
        this.noun = noun;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public String getAdjective() {
        return adjective;
    }

    public void setAdjective(String adjective) {
        this.adjective = adjective;
    }

    public String getSynonymous() {
        return synonymous;
    }

    public void setSynonymous(String synonymous) {
        this.synonymous = synonymous;
    }

    @Override
    public String toString() {
        return "@" + action + ":\t" + pronoun + "\n" +
                "*Adjective" + "\n" + adjective + "\n" +
                "*Noun" + "\n" + noun + "\n" +
                "*Verb" + "\n" + verb + "\n" +
                "*Synonymous" + "\n" + synonymous;

    }


}
