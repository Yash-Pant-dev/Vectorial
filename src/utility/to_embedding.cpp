#include <string>
#include <vector>

template <typename t> t toFloat(const std::string &str){};

template <typename t> class Embedding {
public:
  Embedding(const std::string &input) {
    embedding = toEmbedding(input);
    dim = embedding.size();
  }

  std::vector<t> embedding;
  int dim;

private:
  std::vector<t> toEmbedding(const std::string &input) {
    std::string stringValue;
    t floatValue;
    std::vector<t> embedding;

    for (int i = 0; i < input.size(); i++) {
      if (input[i] == '[')
        continue;
      else if (input[i] == ']' && stringValue != "") {
        floatValue = toFloat<t>(stringValue);
        embedding.push_back(floatValue);
        stringValue = "";
      } else if (input[i] == ',') {
        floatValue = toFloat<t>(stringValue);
        embedding.push_back(floatValue);
        stringValue = "";
      } else
        stringValue += input[i];
    }

    return embedding;
  }
};

template <> float toFloat<float>(const std::string &str) {
  return std::stof(str);
}

template <> double toFloat<double>(const std::string &str) {
  return std::stod(str);
}

template <> long double toFloat<long double>(const std::string &str) {
  return std::stold(str);
}
