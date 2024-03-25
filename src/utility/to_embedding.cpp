#include <string>
#include <vector>
#include "util-headers.hpp"

template <>
float stringToFloat<float>(const std::string &str)
{
  return std::stof(str);
}

template <>
double stringToFloat<double>(const std::string &str)
{
  return std::stod(str);
}

template <>
long double stringToFloat<long double>(const std::string &str)
{
  return std::stold(str);
}


// template <typename t>
// class Embedding
// {
// public:
//   Embedding(const std::string &input)
//   {
//     embedding = toEmbedding(input);
//     dim = embedding.size();
//   }

//   std::vector<t> embedding;
//   int dim;

// private:
//   std::vector<t> toEmbedding(const std::string &input)
//   {
//     std::string stringValue;
//     t floatValue;
//     std::vector<t> embedding;

//     for (int i = 0; i < input.size(); i++)
//     {
//       if (input[i] == '[')
//         continue;
//       else if (input[i] == ']' && stringValue != "")
//       {
//         floatValue = stringToFloat<t>(stringValue);
//         embedding.push_back(floatValue);
//         stringValue = "";
//       }
//       else if (input[i] == ',')
//       {
//         floatValue = stringToFloat<t>(stringValue);
//         embedding.push_back(floatValue);
//         stringValue = "";
//       }
//       else
//         stringValue += input[i];
//     }

//     return embedding;
//   }
// };