#!/bin/bash
echo "Build Tooling for Vectorial DB"

translation_units=("src/main.cpp"
                "src/execute/execute-engine.cpp"
                "src/storage/storage-engine.cpp"
                "src/network/network-engine.cpp"
                "src/query/query-engine.cpp"
                "src/query/parser.cpp"
                "src/utility/get_tokens.cpp"
                "src/utility/log.cpp"
                "src/utility/node_id.cpp"
                "src/utility/to_embedding.cpp")

build_command="g++ -std=c++20"

for i in "${translation_units[@]}"
do
    build_command+=" $i"
done

build_dir=" -o build/vectorial.exe"

build_command+=$build_dir

echo $build_command
eval "$build_command"