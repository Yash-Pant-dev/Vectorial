#pragma once
#include <string>
#include <vector>

template <typename t>
t stringToFloat(const std::string &str);

template <typename t>
class Embedding
{
public:
  Embedding(const std::string &input)
  {
    embedding = toEmbedding(input);
    dim = embedding.size();
  }

  std::vector<t> embedding;
  int dim;

private:
  std::vector<t> toEmbedding(const std::string &input)
  {
    std::string stringValue;
    t floatValue;
    std::vector<t> embedding;

    for (int i = 0; i < input.size(); i++)
    {
      if (input[i] == '[')
        continue;
      else if (input[i] == ']' && stringValue != "")
      {
        floatValue = stringToFloat<t>(stringValue);
        embedding.push_back(floatValue);
        stringValue = "";
      }
      else if (input[i] == ',')
      {
        floatValue = stringToFloat<t>(stringValue);
        embedding.push_back(floatValue);
        stringValue = "";
      }
      else
        stringValue += input[i];
    }

    return embedding;
  }
};