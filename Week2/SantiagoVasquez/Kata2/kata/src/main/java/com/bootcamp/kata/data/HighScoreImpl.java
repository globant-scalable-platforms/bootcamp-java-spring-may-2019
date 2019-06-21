package com.bootcamp.kata.data;

import java.util.*;

public class HighScoreImpl implements HighScoreGameInterface {

    private Map<String, List<Integer>> participants;
    private String highScorePlayer;

    public HighScoreImpl() {
        participants = new HashMap<>();
    }

    @Override
    public String participate(String player, int score) {
        if (participants.containsKey(player)) {
            final List<Integer> scores = participants.get(player);
            addScore(scores, score);

            if (scores.size() == 3) {
                calculateWinner();
            }
        } else {
            participants.put(player, new ArrayList<>(Arrays.asList(score)));
        }

        return highScorePlayer;
    }

    /**
     * Add an score to a participant
     * Limit scores to 3 (mandatory)
     *
     * @param scores
     * @param score
     */
    private void addScore(List<Integer> scores, int score) {
        if (scores.size() >= 3) {
            return;
        }
        scores.add(score);
    }

    private void calculateWinner() {
        int highScore = 0;
        participants.forEach((player, scores) -> {
            if (scores.size() >= 3) {
                int total = scores.stream().reduce(0, Integer::sum);
                if (total > highScore)
                    highScorePlayer = player;
            }
        });
    }
}
