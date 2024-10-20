def solution(a, b):
    cnt_days_in_months_reap = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    days_of_the_week = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI','SAT']
    start_day_idx = 5
    target_day_idx = (sum(cnt_days_in_months_reap[:a-1])+b+start_day_idx-1)%len(days_of_the_week)
    return days_of_the_week[target_day_idx]