class Solution {
    public String convert(String str, int numRows) {
        if(numRows==1){
            return str;
        }
		char [][] ch=new char[(str.length()/(numRows-1))+1][numRows-1];
		int rows=ch.length,columns=ch[0].length,ind=0,x=1,y=columns-1;
		String first="",second="";
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns && ind<str.length(); j++) {
				ch[i][j]=str.charAt(ind);
				ind++;
			}
			if(i%2==0){
				first+=ch[i][0];
			}
			else{
				second+=ch[i][0];
			}
		}
		for (int j = 0; j < columns-1 && x<columns && y>0; j++) {
			for (int i = 0; i < rows; i++) {
				if(i%2==0){
					first+=ch[i][x];
				}
				else{
					first+=ch[i][y];
				}
			}
			x++;y--;
		}
        String ans="";
        for(int i=0;i<first.length();i++){
            if(first.charAt(i)!='\u0000')
                ans+=first.charAt(i);
        }
        for(int i=0;i<second.length();i++){
            if(second.charAt(i)!='\u0000')
                ans+=second.charAt(i);
        }
        return ans;
    }
}
