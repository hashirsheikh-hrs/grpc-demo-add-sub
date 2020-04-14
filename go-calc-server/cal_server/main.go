/*
 *
 * Copyright 2015 gRPC authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

//go:generate protoc -I ../helloworld --go_out=plugins=grpc:../helloworld ../helloworld/helloworld.proto

// Package main implements a server for Greeter service.
package main

import (
	"context"
	"log"
	"net"

	"google.golang.org/grpc"
	pb "google.golang.org/grpc/examples/go-calc-server/calculator"
)

const (
	port = ":50051"
)

// server is used to implement calculator.CalculatorServer
type server struct {
	pb.UnimplementedCalculatorServer
}

func (s *server) Add(ctx context.Context, in *pb.AddRequest) (*pb.AddReply, error) {
	log.Printf("Received: %v %v", in.GetX(), in.GetY())
	return &pb.AddReply{Sum: (in.GetX() + in.GetY())}, nil
}

func (s *server) Subtract(ctx context.Context, in *pb.SubtractRequest) (*pb.SubtractReply, error) {
	log.Printf("Received: %v %v", in.GetX(), in.GetY())
	return &pb.SubtractReply{Diff: (in.GetX() - in.GetY())}, nil
}

func main() {
	log.Printf("test")
	lis, err := net.Listen("tcp", port)
	log.Printf("test 1")
	if err != nil {
		log.Printf("failed to listen:")
		log.Fatalf("failed to listen: %v", err)
	}
	log.Printf("test 2")
	s := grpc.NewServer()
	log.Printf("test 3")
	pb.RegisterCalculatorServer(s, &server{})
	log.Printf("test 4")
	log.Printf("Server Started: ")
	if err := s.Serve(lis); err != nil {
		log.Printf("failed to serve: ")
		log.Fatalf("failed to serve: %v", err)
	}
	log.Printf("test 5")
}
