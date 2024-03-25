#include "./parser.cpp"
#include <iostream>
#include <string>
#include "../utility/util-headers.h"
#include "../network/network-engine.cpp"

namespace Query {
void init();
}

void init() {
  while (1) {
    std::string input;

    if (Network::queryWaiting()) {
      input = Network::getQuery();
    }
    else std::getline(std::cin, input);

    bool validQuery = handleQuery(input);
    if (!validQuery)
      log("Inv Q - " + input);
  }
}
