package com.elpezpr.PostShare.util;

import com.elpezpr.PostShare.model.Post;
import com.elpezpr.PostShare.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading data...");

        Post post1 = new Post("The Rise of Modern Technology",
                "The rapid evolution of technology has transformed various aspects of our lives, from communication to industry. This post delves into how technology has changed over the decades and what to expect in the future.",
                "John Smith");
        postRepository.save(post1);

        Post post2 = new Post("Exploring the Depths of Space",
                "Space exploration has always fascinated humanity. This post covers the challenges and achievements of exploring outer space, from early missions to the latest breakthroughs in space travel.",
                "Jane Doe");
        postRepository.save(post2);

        Post post3 = new Post("The Future of Artificial Intelligence",
                "Artificial Intelligence (AI) is shaping the future with its capabilities. This post discusses the potential advancements in AI technology and its implications for various industries.",
                "Emily Johnson");
        postRepository.save(post3);

        Post post4 = new Post("Understanding Quantum Computing",
                "Quantum computing represents a new frontier in technology. This post explains the principles of quantum computing and how it could revolutionize problem-solving capabilities.",
                "Michael Brown");
        postRepository.save(post4);

        Post post5 = new Post("The Impact of Climate Change",
                "Climate change is one of the most pressing issues of our time. This post examines the effects of climate change on the environment and explores potential solutions for mitigating its impact.",
                "Sarah Davis");
        postRepository.save(post5);

        Post post6 = new Post("The Evolution of Web Development",
                "Web development has evolved significantly over the years. This post reviews the history of web development and the technologies that have driven its progress.",
                "David Wilson");
        postRepository.save(post6);

        Post post7 = new Post("History of Blockchain Technology",
                "Blockchain technology is the backbone of cryptocurrencies and beyond. This post provides an overview of blockchain technology's development and its diverse applications.",
                "Laura Martinez");
        postRepository.save(post7);

        Post post8 = new Post("Innovations in Renewable Energy",
                "Renewable energy is crucial for sustainable development. This post highlights recent innovations in renewable energy sources and their potential to address global energy needs.",
                "James Taylor");
        postRepository.save(post8);

        Post post9 = new Post("The Benefits of Mindfulness",
                "Mindfulness practices can greatly enhance personal well-being. This post explores the benefits of mindfulness and offers tips for incorporating it into daily life.",
                "Jessica Anderson");
        postRepository.save(post9);

        Post post10 = new Post("Advancements in Medical Science",
                "Medical science is rapidly advancing with new discoveries and technologies. This post reviews recent advancements in medical science and their implications for healthcare.",
                "William Thomas");
        postRepository.save(post10);

        Post post11 = new Post("The Art of Creative Writing",
                "Creative writing is an expressive form of art. This post provides insights into the techniques of creative writing and how to craft engaging stories.",
                "Sophia Harris");
        postRepository.save(post11);

        Post post12 = new Post("Trends in Mobile Technology",
                "Mobile technology continues to evolve with new trends. This post discusses the latest trends in mobile technology and their impact on users and businesses.",
                "Daniel Lewis");
        postRepository.save(post12);

        Post post13 = new Post("The Role of Big Data in Business",
                "Big data is transforming business strategies. This post explains how big data is used in business and the tools available for analyzing and leveraging data.",
                "Olivia Clark");
        postRepository.save(post13);

        Post post14 = new Post("The Psychology of Human Behavior",
                "Understanding human behavior is essential in various fields. This post delves into psychological theories and their applications in understanding behavior and decision-making.",
                "Matthew Walker");
        postRepository.save(post14);

        Post post15 = new Post("The Growth of E-commerce",
                "E-commerce has seen significant growth in recent years. This post explores the factors contributing to the rise of e-commerce and its impact on traditional retail.",
                "Ava Young");
        postRepository.save(post15);

        Post post16 = new Post("The Significance of Data Privacy",
                "Data privacy is a critical concern in the digital age. This post discusses the importance of data privacy and the measures individuals and organizations can take to protect it.",
                "Ethan Allen");
        postRepository.save(post16);

        Post post17 = new Post("Developments in Augmented Reality",
                "Augmented reality (AR) is creating new possibilities in various fields. This post reviews the latest developments in AR technology and its potential applications.",
                "Isabella Wright");
        postRepository.save(post17);

        Post post18 = new Post("The Challenges of Urbanization",
                "Urbanization presents both opportunities and challenges. This post examines the issues related to urbanization and potential strategies for managing urban growth.",
                "Liam Scott");
        postRepository.save(post18);

        Post post19 = new Post("The History of Space Exploration",
                "Space exploration has a rich history of exploration and discovery. This post provides an overview of the key milestones in the history of space exploration.",
                "Charlotte Green");
        postRepository.save(post19);

        Post post20 = new Post("The Economics of Cryptocurrency",
                "Cryptocurrency is influencing financial markets. This post explores the economic impact of cryptocurrency and its role in modern finance.",
                "Noah Adams");
        postRepository.save(post20);

        Post post21 = new Post("Ethics in Artificial Intelligence",
                "The development of AI raises important ethical questions. This post addresses the ethical considerations in AI development and its implications for society.",
                "Amelia Baker");
        postRepository.save(post21);

        Post post22 = new Post("The Future of Autonomous Vehicles",
                "Autonomous vehicles are shaping the future of transportation. This post explores the current state of autonomous vehicles and what the future might hold.",
                "Jacob Turner");
        postRepository.save(post22);

        Post post23 = new Post("The Influence of Social Media",
                "Social media has a profound impact on society. This post discusses the influence of social media on communication, behavior, and social interactions.",
                "Mia Rodriguez");
        postRepository.save(post23);

        Post post24 = new Post("Understanding Genetic Engineering",
                "Genetic engineering is transforming various fields, from medicine to agriculture. This post provides an overview of genetic engineering techniques and their applications.",
                "Alexander Collins");
        postRepository.save(post24);

        Post post25 = new Post("The Power of Digital Marketing",
                "Digital marketing is essential for modern businesses. This post covers the strategies and tools used in digital marketing and their effectiveness in reaching target audiences.",
                "Harper Nelson");
        postRepository.save(post25);

        Post post26 = new Post("The Wonders of Marine Biology",
                "Marine biology is the study of ocean life. This post explores the wonders of marine biology, including marine ecosystems, species, and conservation efforts.",
                "Benjamin Murphy");
        postRepository.save(post26);

        Post post27 = new Post("The Principles of Software Engineering",
                "Software engineering involves systematic approaches to software development. This post outlines the key principles of software engineering and best practices for creating reliable software.",
                "Ella Rivera");
        postRepository.save(post27);

        Post post28 = new Post("Sustainable Agriculture Practices",
                "Sustainable agriculture focuses on practices that are environmentally friendly and economically viable. This post discusses sustainable agriculture practices, including organic farming, crop rotation, and soil conservation techniques.",
                "Zachary Evans");
        postRepository.save(post28);

        Post post29 = new Post("The Evolution of Internet Security",
                "Internet security is crucial in the digital age to protect data and privacy. This post explores the evolution of internet security measures, including encryption technologies, firewalls, and modern security practices to combat cyber threats.",
                "Alicia Fisher");
        postRepository.save(post29);

        Post post30 = new Post("The Role of Biotechnology in Medicine",
                "Biotechnology is revolutionizing medicine through innovative therapies and treatments. This post covers the role of biotechnology in medicine, including gene therapy, personalized medicine, and advances in medical research.",
                "Bradley Wright");
        postRepository.save(post30);
    }
}