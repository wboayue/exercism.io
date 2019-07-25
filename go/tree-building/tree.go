package tree

import (
	"fmt"
)

type Record struct {
	ID, Parent int
}

type Node struct {
	ID int
	Children []*Node
}

func Build(records []Record) (*Node, error) {
	if len(records) < 1 {
		return nil, nil
	}

	nodes := make(map[int]*Node)
	children := []*Record{}

	for _, record := range records {
		_, ok := nodes[record.ID]

		if ok {
			return nil, fmt.Errorf("Found duplicate node: %d", record.ID)
		}

		if record.ID == 0 {
			if record.Parent == 0 {
				nodes[record.ID] = &Node{ID: record.ID}
				continue
			} else {
				return nil, fmt.Errorf("root has parent")			
			}
		}

		if !(record.ID > record.Parent) {
			return nil, fmt.Errorf("Higher id[%d] parent of lower id[%d]", record.Parent, record.ID)
		}

		nodes[record.ID] = &Node{ID: record.ID}
	}

	for _, record := range children {
		_, ok := nodes[record.Parent]

		if !ok {
			return nil, fmt.Errorf("Parent not found: %d", record.Parent)
		}

		nodes[record.Parent].Children = append(nodes[record.Parent].Children, nodes[record.ID]) 
	}

	root, ok := nodes[0]

	if ok {
		return root, nil
	} else {
		return nil, fmt.Errorf("No root node found")
	}
}
