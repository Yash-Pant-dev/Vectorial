#pragma once
#include <string>
#include <vector>
#include "to_embedding.hpp"

// log.cpp
void log(const std::string &input);

// node_id.cpp
int getNodeID();

// get_tokens.cpp
std::vector<std::string> getTokens(std::string &input);

// Node config
struct nodeConfig
{
  int nodeThreads;
  bool nodeGPU;
};
