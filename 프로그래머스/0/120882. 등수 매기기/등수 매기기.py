def solution(score):
    avg_score = [(i, sum(scr) / len(scr)) for i, scr in enumerate(score)]
    sorted_avg = sorted(avg_score, key=lambda x: -x[1])
    ranking = {}
    rank = 1
    prev_score = None
    for i, (idx, avg) in enumerate(sorted_avg):
        if avg != prev_score:
            rank = i + 1
        ranking[idx] = rank
        prev_score = avg
    return [ranking[i] for i in range(len(score))]