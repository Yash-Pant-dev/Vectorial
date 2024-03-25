#include <iostream>
#include "utility/node_id.cpp"
std::string SEMANTIC_VERSION = "0.1.1";

int main() {
  std::cout << "Vectorial Database -v " << SEMANTIC_VERSION << '\n';
  std::cout << "Node ID " << getNodeID() << '\n';

  Query::init();
  Storage::init();
  Network::init();
  Execute::init(NODE_CONFIG);
  
}

const struct nodeConfig {
  int nodeThreads;
  bool nodeGPU;
} NODE_CONFIG{4, false};
