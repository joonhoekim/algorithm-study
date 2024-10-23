def solution(spell, dic):
    
    spell_set = set(spell)
    
    for word in dic:
        word_set = set(word)
        if word_set == spell_set:
            return 1
    
    return 2