cmake_minimum_required(VERSION 3.4.1)

file(GLOB SOURCES src/main/cpp/*.cpp)
file(GLOB LIBPNG src/main/cpp/libpng/*.c)
file(GLOB NEON src/main/cpp/libpng/arm/*.c)
file(GLOB NEONS src/main/cpp/libpng/arm/*.S)

set(CMAKE_SHARED_LINKER_FLAGS "${CMAKE_SHARED_LINKER_FLAGS} \
                               -Wl,--gc-sections -Wl,--exclude-libs,ALL")

add_library(
        png-decoder
        SHARED
        ${SOURCES} ${LIBPNG} ${NEON} ${NEONS}
)

target_link_libraries(
        png-decoder
        jnigraphics
        z
)
