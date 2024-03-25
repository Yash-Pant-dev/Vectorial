#include <string>
#include <vector>
std::vector<std::string> getTokens(std::string &input) {
  
  std::vector<std::string> tokens;
  std::string curToken("");
  
  for (int i = 0; i < input.length(); i++) {
    if (input[i] != ' ')
      curToken += input[i];
    else {
      tokens.push_back(curToken);
      curToken.clear();
    }
  }

  return tokens;
}
