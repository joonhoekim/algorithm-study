def solution(video_len, pos, op_start, op_end, commands):
    
    def validate(acc_sec):
        # max check
        if acc_sec > acc_max:
            return acc_max
        # min check
        if acc_sec < 0:
            return 0
        # op skip check
        if acc_op_start <= acc_sec < acc_op_end:
            return acc_op_end
        
        else:
            return acc_sec
    
    def format_time(acc_sec):
        # MM:SS
        int_m = acc_sec // 60
        int_s = acc_sec % 60
        str_m = f'{int_m:02d}'
        str_s = f'{int_s:02d}'
        return ':'.join([str_m, str_s])
    
    answer = ''
    
    interval = 10
    
    curr_min, curr_sec = map(int, pos.split(':'))
    acc_curr = curr_min * 60 + curr_sec
    
    max_min, max_sec = map(int, video_len.split(':'))
    acc_max = max_min * 60 + max_sec
    
    op_start_min, op_start_sec = map(int, op_start.split(':'))
    acc_op_start = op_start_min * 60 + op_start_sec
    
    op_end_min, op_end_sec = map(int, op_end.split(':'))
    acc_op_end = op_end_min * 60 + op_end_sec
    
    for command in commands:
        acc_curr = validate(acc_curr)
        
        if command == 'next':
            acc_curr += interval
            
        elif command == 'prev':
            acc_curr -= interval
            
        acc_curr = validate(acc_curr)
    
    answer = format_time(acc_curr)
    
    return answer