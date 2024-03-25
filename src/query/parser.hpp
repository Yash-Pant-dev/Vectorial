#include <string>
#include <vector>

typedef std::vector<std::string> tokens_t;

bool handleQuery(std::string &input);
void executeOperation(const tokens_t&);

bool tableOperation(const tokens_t&);
bool indexOperation(const tokens_t&);
bool recordOperation(const tokens_t&);