package coding.challenge.basic.day12;

import java.util.*;

class Solution {
    static class Song {
        int id;
        int plays;

        public Song(int id, int plays) {
            this.id = id;
            this.plays = plays;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayMap = new HashMap<>();
        Map<String, List<Song>> genreSongsMap = new HashMap<>();

        // 1. 집계
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            genrePlayMap.put(genre, genrePlayMap.getOrDefault(genre, 0) + play);
            genreSongsMap.computeIfAbsent(genre, k -> new ArrayList<>())
                    .add(new Song(i, play));
        }

        // 2. 장르 정렬 (재생 수 총합 기준 내림차순)
        List<String> genreOrder = new ArrayList<>(genrePlayMap.keySet());
        genreOrder.sort((g1, g2) -> genrePlayMap.get(g2) - genrePlayMap.get(g1));

        // 3. 장르별 곡 정렬 및 상위 2곡 선택
        List<Integer> result = new ArrayList<>();
        for (String genre : genreOrder) {
            List<Song> songs = genreSongsMap.get(genre);
            songs.sort((s1, s2) -> {
                if (s1.plays != s2.plays) return s2.plays - s1.plays;
                return s1.id - s2.id;
            });

            result.add(songs.get(0).id);
            if (songs.size() > 1) {
                result.add(songs.get(1).id);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})));
    }
}
