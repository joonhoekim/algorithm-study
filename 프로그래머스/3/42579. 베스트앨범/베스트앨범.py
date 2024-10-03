def solution(genres, plays):
    from collections import defaultdict

    answer = []

    genre_play_table = defaultdict(list)
    genres_plays_sum = defaultdict(int)

    for i, (genre, play) in enumerate(zip(genres, plays)):
        genre_play_table[genre].append((i, play))
        genres_plays_sum[genre] += play

    sorted_genres = sorted(genres_plays_sum, key=genres_plays_sum.get, reverse=True)

    answer=[]
    for genre in sorted_genres:
        sorted_songs = sorted(genre_play_table[genre],
                              key=lambda x: (-x[1], x[0]))
        answer.extend([
            song[0] for song in sorted_songs[:2]
        ])
    

    return answer