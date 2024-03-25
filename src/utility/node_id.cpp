#include <random>

int getNodeID() {
  std::random_device random_device;
  std::mt19937 mersenneRNG(random_device());
  std::uniform_int_distribution<std::mt19937::result_type> spread(1, 50000);

  return spread(mersenneRNG);
}
