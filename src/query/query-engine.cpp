#include "parser.hpp"
#include <iostream>
#include <string>
#include "../utility/util-headers.hpp"
#include "../network/network-engine.hpp"
#include "query-engine.hpp"

void Query::init()
{
  while (1)
  {
    std::string input;

    if (Network::queryWaiting())
    {
      input = Network::getQuery();
    }
    else
      std::getline(std::cin, input);

    bool validQuery = handleQuery(input);
    if (!validQuery)
      log("Inv Q - " + input);
  }
}
