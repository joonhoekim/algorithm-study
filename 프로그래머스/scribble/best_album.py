def solution(genres, plays):
    from collections import defaultdict

    answer = []

    genre_play_table = defaultdict(list)
    genres_plays_sum = defaultdict(int)

    for i, (genre, play) in enumerate(zip(genres, plays)):
        genre_play_table[genre].append((i, play))
        genres_plays_sum[genre] += play

    sorted_genres = sorted(genres_plays_sum, key=genres_plays_sum.get, reverse=True)
    
    # without key like below, will be sorted by just a key
    # sorted_genres = sorted(genres_plays_sum, reverse=True)

    answer=[]
    for genre in sorted_genres:
        sorted_songs = sorted(genre_play_table[genre],
                              key=lambda x: (-x[1], x[0]))
        answer.extend([
            song[0] for song in sorted_songs[:2]
        ])
    

    return answer


genres = ["classic", "pop", "classic", "classic", "pop"]
plays = [500, 600, 150, 800, 2500]

print(solution(genres, plays))
