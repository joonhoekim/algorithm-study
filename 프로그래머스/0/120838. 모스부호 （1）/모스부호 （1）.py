def solution(letter):
    morse = { 
    '.-':'a','-...':'b','-.-.':'c','-..':'d','.':'e','..-.':'f',
    '--.':'g','....':'h','..':'i','.---':'j','-.-':'k','.-..':'l',
    '--':'m','-.':'n','---':'o','.--.':'p','--.-':'q','.-.':'r',
    '...':'s','-':'t','..-':'u','...-':'v','.--':'w','-..-':'x',
    '-.--':'y','--..':'z'
    }
    cursor_start = 0
    cursor_end = 0
    translated = []
    list_letter = letter.split()
    for i in range(len(list_letter)+1):
        target = ''.join(list_letter[cursor_start:cursor_end])
        if target in morse.keys():
            cursor_start = cursor_end
            translated.append(morse[target])
        cursor_end += 1
    return ''.join(translated)
        