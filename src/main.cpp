#include <iostream>
#include "./utility/util-headers.hpp"
#include "network/network-engine.hpp"
#include "storage/storage-engine.hpp"
#include "query/query-engine.hpp"
#include "execute/execute-engine.hpp"

std::string SEMANTIC_VERSION = "0.1.1";

const nodeConfig NODE_CONFIG{4, false};

int main() {
  std::cout << "Vectorial Database -v " << SEMANTIC_VERSION << '\n';
  std::cout << "Node ID " << getNodeID() << '\n';

  Query::init();
  Storage::init();
  Network::init();
  Execute::init(NODE_CONFIG);
  
}
