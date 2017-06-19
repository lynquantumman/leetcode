class Solution(object):
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        
        dicts2t = {}
        for i in range(len(s)):
        	if s[i] in dicts2t:
        		if dicts2t[s[i]]!=t[i]:
        			return False
        	else:
        		dicts2t[s[i]] = t[i]

        dictt2s = {}
        for i in range(len(t)):
        	if t[i] in dictt2s:
        		if dictt2s[t[i]]!=s[i]
        			return False

        	else:
        		dictt2s[t[i]] = s[i]