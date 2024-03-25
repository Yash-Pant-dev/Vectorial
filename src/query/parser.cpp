// TODO: Re-implement later using enums
#include "parser.hpp"
#include "../utility/util-headers.hpp"

bool error = false;

bool handleQuery(std::string &input) {
  tokens_t tokens = getTokens(input);
  if (tokens[0] != "Q|" && tokens[tokens.size() - 1] != "|Q")
    log("Inv Q -" + input);
  
  executeOperation(tokens);
  return !error;
}

void executeOperation(const tokens_t &tokens) { 
  if (tokens[1] == "T") {
    tableOperation(tokens);
  }
  else if (tokens[1] == "I") {
    indexOperation(tokens);
  }
  else if (tokens[1] == "R") {
    recordOperation(tokens);
  }
}

bool tableOperation(const tokens_t &tokens) {
  if (tokens[2] == "C") {
    
  }
  else if (tokens[2] == "S") {

  }
  else if (tokens[2] == "D") {

  }
  return false;
}

bool indexOperation(tokens_t &tokens) {
  const Embedding<float> embedding(tokens[2]);
  // find similarity
  return true;
}

bool recordOperation(tokens_t &tokens) {
  if (tokens[2] == "C") {

  }
  else if (tokens[2] == "R") {

  }
  else if (tokens[2] == "U") {

  }
  else if (tokens[2] == "D") {

  }

  return false;
} 
